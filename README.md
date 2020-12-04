# Business-rules-engine

## Produtos

### Criar
**HTTP POST** https://business-rules-engine.herokuapp.com/product

```
{
	"nome": "Armário 2 portas com espelho",
	"marca": "Armarino",
	"descricao": "Armário com espelho",
	"quantidade": 3,
	"precoDeVenda": 1000,
	"precoDeCompra": 700,
	"dataDeValidade": "2025-11-16T00:00:00Z"
}
```

**Success Response**
```
{
	"id": 1
}
```

**Error Response**
```
{
	"errors": [
		{
			"rule": {
				"id": 1,
				"rule": "quantidade > 0",
				"errorDescription": "A quantidade deve ser maior que zero!"
			}
		}
	]
}
```

### Consultar
**HTTP GET** https://business-rules-engine.herokuapp.com/product

**Response**: HTTP 200
```
[
	{
		"id": 5,
		"nome": "Armário 2 portas com espelho",
		"descricao": "Armário com espelho",
		"marca": "Armarino",
		"quantidade": 3,
		"dataDeValidade": "2025-11-16",
		"precoDeVenda": 1000.0,
		"precoDeCompra": 700.0
	}
]
```

### Deletar
**HTTP DELETE** https://business-rules-engine.herokuapp.com/product/:id
**Success Response**: HTTP 204 - NO CONTENT
**Error Response**: HTTP 404 - NOT FOUND

## REGRAS

### Criar
**HTTP POST** https://business-rules-engine.herokuapp.com/rule

```
{
	"rule": "quantidade > 0",
	"errorDescription": "A quantidade deve ser maior que zero!"
}
```

**Success Response**
```
{
	"id": 1
}
```

**Error Response**: HTTP 401 BAD REQUEST

### Consultar
**HTTP GET** https://business-rules-engine.herokuapp.com/rule

**Response**: HTTP 200
```
[
	{
		"id": 1,
		"rule": "quantidade > 0",
		"errorDescription": "A quantidade deve ser maior que zero!"
	}
]
```

### Deletar
**HTTP DELETE** https://business-rules-engine.herokuapp.com/rule/:id
**Success Response**: HTTP 204 - NO CONTENT
**Error Response**: HTTP 404 - NOT FOUND
