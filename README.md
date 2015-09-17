Best Logistics
=======
Esse sistema pretende melhorar as entregas aplicando uma logística que sempre visa o menor custo :)  

[![Circle CI](https://circleci.com/gh/DenisSMoreira/best-logistics/tree/master.svg?style=svg)](https://circleci.com/gh/DenisSMoreira/best-logistics/tree/master)

**Sobre a solução** 
-------  

**Ferramentas útilizadas**

  * Java 8: Alem de ter acabado de sair do forno, o java 8 vem com features realmente interessantes que pode vir a ser bem útil no crescimento dessa solução, tais como desempenho aprimorado, lambda, streams entre outros, e não queremos um sistema lento para nossos clientes, não é? Eis o motivo da minha escolha!
  
  * Maven 3: Ótimo gereciador de dependências (diga não ao .jar em classpath!) escolhi ele pois tenho grande domínio. 
  
  * MongoDB: Ele vem como uma grande promessa dos últimos tempos, e tem meu voto de confiança já que trabalho com ele a algum tempo e ele não vem me decepcionando, existi sim outros bancos de dados não relacionais que mostram um desempenho ainda melhor que ele, porém o motivo da minha escolha foi sua estabilidade e a facilidade que tenho em trabalhar com ele.
  
  * Spring-boot: Nós programadores, sabemos como é custoso criar o fundation do projeto em tempo de sprint não é? Ai que vem o Spring-boot como um salvador e facilitador  
 para dar um start mais rápido e com pré-configurações que vem muito a calhar para projetos que precisam ser feito com qualidade e com cronograma apertado.
 
  * Swagger: Quando se fala em integração, sempre vem aquele friozinho na barriga na hora da estimativa não é? E como garantir que quem vai consumir seu webservice não irá perder horas de stress, em uma tarefa que era para ser fácil e rápido finalizando até mesmo antes nosso café expresso? Minha maior motivação em usar essa ferramenta vem na facilidade de exposição da camada rest-full para facilitar a integração e poder garantir que quem irá ficar responsável ficará muito feliz em ter essa tarefa.
    
![ScreenShot](https://github.com/DenisSMoreira/walmart-challenge/blob/master/src/main/webapp/swagger/images/print_swagger.jpg?raw=true)
    
    
**Requisitos da aplicação**
    
  * Oracle JDK 8u20
  * Apache Maven 3.3.3
  * MongoDB 3.0   
  * Git
 
**Build Project**   

   Abra o terminal e execute o seguinte comando para baixar o repositorio:
   
```
    git clone https://github.com/DenisSMoreira/best-logistics.git
```
 Em seguida execute o seguinte comando, lembre-se de verificar se os softwares requeridos estão em execução e instalados, porque existe um pequeno teste de integração.
 
```
    mvn clean install
    mvn spring-boot:run
```

 Agora é só abrir a seguinte URL no browser para ter acesso a API do swagger para poder consumir o webservice, lá existirá o JSON SCHEMA para exemplo e as urls:
 
 ```
 localhost:8080/swagger/index.html
 ```
