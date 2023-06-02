# TesteTecnicoMaximaTech

Sistema de Cadastrado de cliente junto com endereço, existe validações de campos com Cnpj, e Cep.  
para buscar o cep esta sendo usada uma api externa chamada viaCep  

### obs: para rodar aplicação com o Docker rodar o comando:
build --build-arg JAR_FILE=target/*.jar -t myorg/myapp .

Banco de Dados H2, em memória.

EndPoint para fazer as requisições (http://localhost:8080/clientes)

### Para Cadastro de cliente Metodo Post passar o corpo da requisição em json:

{  

 "nome":"xandao",    
  "codigo":"1516",  
  "cpnj":"15.436.940/0001-03",  
    "endereco": {  
    "cep":"01025020",   
    "complemento":"apto 47",  
    "numero":"331"  
    }     
    
}


o cep ira trazer todas as outras informações de endereço.
Caso se digite o cnpj errado ou algum campo obrigatorio faltar a API mandara uma mensagem de erro.

### Para Atualizar cliente Metodo Put passar o mesmo corpo da requisição do cadastro mais com a url passando o Id exemplo. 
http://localhost:8080/clientes/1)
Caso digite um Id Inexistente a API mandara uma mensagem de erro.

### Para Realizar uma paginacao entre os clientes Usar o Metódo Get na url
http://localhost:8080/clientes

é necessario passar um dos dois parametros para que funcione,o atributo nome ou o atributo logradouro, na url ficaria assim: 

http://localhost:8080/clientes?nome=nomeTeste  
ou  
http://localhost:8080/clientes?logradouro=Rua Exemplo da silva









