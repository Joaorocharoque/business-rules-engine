package com.company.businessrulesengine.application;

import com.company.businessrulesengine.model.Product;
import com.company.businessrulesengine.model.ProductNotFoundException;
import com.company.businessrulesengine.model.ProductRepository;
import com.company.businessrulesengine.spel.RuleExecutionResponse;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProductService {

    @Autowired
    private RuleService ruleService;

    @Autowired
    private ProductRepository productRepository;

    public SaveProductResponseDTO save(Product product){
        Collection<RuleExecutionResponse> errors = ruleService.applyRules(product);
        if(CollectionUtils.isEmpty(errors)){
            Product savedProduct = productRepository.save(product);
            return new SaveProductResponseDTO(savedProduct.getId());

        }
        return new SaveProductResponseDTO(errors);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public Collection<Product> findAll() {
        return productRepository.findAll();
    }

    public void update(Product newProduct, Long id) {
        Product product = productRepository.findById(id)
                .map(oldProduct -> Product.Builder.aProduct()
                        .id(id)
                        .dataDeValidade(newProduct.getDataDeValidade())
                        .descricao(newProduct.getDescricao())
                        .marca(newProduct.getMarca())
                        .nome(newProduct.getNome())
                        .precoDeCompra(newProduct.getPrecoDeCompra())
                        .precoDeVenda(newProduct.getPrecoDeVenda())
                        .quantidade(newProduct.getQuantidade())
                        .build())
                .orElseThrow(() -> new ProductNotFoundException(id));
        productRepository.save(product);
    }
}
