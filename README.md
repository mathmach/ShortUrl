# ShortUrl
Encurtador de URL

Aplicação criada utilizando:

  * SpringBoot (2.1.4) + SpringData + Flyway + MySQL (5.7.25)
  * IDE Netbeans 11.0
  * Java OpenJDK 11 

### Requisitos

  * MySQL
  * Java 9

### Testando a API

A aplicação utiliza a porta :8080 para seu funcionamento.
Assim que a aplicação é iniciada, é fornecido um endpoint para cadastro de urls no caminho '/shortener'

Corpo da mensagem a ser enviada ao endpoint '/shortener'


```
{
  "alias": string,  // Campo de identificação única para uma URL personalizada;
  "url" : string    // URL (Válida) na qual a aplicação irá redirecionar
}
```

**OBS:** O Campo da url possui um validador utilizando o RegEx `^(http://|https://)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{2}.?([a-zA-Z]+)?$`

### Screenshot (via Postman)

**Exemplo de uma requisição POST**

(Printscreen de uma requisição POST feita a partir do Postman com sua respectiva resposta)

![Screenshot Post](https://github.com/mathmach/ShortUrl/blob/master/screenshot/post.png)



**Exemplo de uma requisição GET**

(Printscreen de uma requisição GET feita a partir do Postman com sua respectiva resposta)

![Screenshot Get](https://github.com/mathmach/ShortUrl/blob/master/screenshot/get.png)
