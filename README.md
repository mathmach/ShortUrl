# ShortUrl
Encurtador de URL

Aplicação criada utilizando:

  * SpringBoot (2.1.4) + SpringData + Flyway + MySQL (5.7.25)
  * IDE Netbeans 11.0
  * Java OpenJDK 11 

### Requisitos

  * MySQL
  * Java 9

### Funcionamento

A aplicação utiliza a porta :8080 para seu funcionamento.

### Endpoints

  * **/api/v2/shortener** // API para criação de URL's encurtadas
  * **/swagger-ui.html**  // Documentação gerada automáticamente para realização de testes com a API
  * **/r/{alias}**        // Redirecionamento para URL encurtada, onde {alias} é a identificação cadastrada pelo usuário

### Testando a API

Para testes foi implementado o Swagger v2.0 para geração automática da documentação e implementação dos endpoints no caminho '/swagger-ui.html'

Assim que a aplicação é iniciada, é fornecido um endpoint para cadastro de urls no caminho '/api/v2/shortener'

Corpo da mensagem a ser enviada ao endpoint '/api/v2/shortener' utilizando Bearer Token:

**OBS:** Por não ter uma persistência para os tokens, qualquer valor utilizado será autorizado

```
{ 
  "alias": string,  // Campo de identificação única para uma URL personalizada;
  "url" : string    // URL (Válida) na qual a aplicação irá redirecionar
}
```

**OBS:** O Campo da url possui um validador utilizando o RegEx `^(http://|https://)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{2}.?([a-zA-Z]+)?$`

Corpo da mensagem de resposta do servidor:

```
{
  "timestamp": long,
  "status": int,
  "data": string, // URL encurtada
  "error": string,
  "errors": array
}
```

### Screenshot (via Postman)

**Exemplo de uma requisição POST**

(Printscreen de uma requisição POST feita a partir do Postman com sua respectiva resposta)

![Screenshot Post](https://github.com/mathmach/ShortUrl/blob/master/screenshot/post.png)



**Exemplo de uma requisição GET**

(Printscreen de uma requisição GET feita a partir do Postman com sua respectiva resposta)

![Screenshot Get](https://github.com/mathmach/ShortUrl/blob/master/screenshot/get.png)
