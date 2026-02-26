# API-de-Tasks-com-JDBCTemplate

<div>
  <p>Foi usado arquitetura em camadas (Controller, Service e Repository), com objetivo de fixar melhor os conceitos e aprender coisas novas</p>
  <p>Com o uso do JDBC Template pude entender melhor como funciona por trás dos panos o envio de dados para o banco de dados</p>
</div>
<div>
  <h2>Desafios:</h2>
  <div>
    <ul>
      <li>Tive um pouco de difículdade para entende sobre update, query e execute</li>
      <li>Treinei melhor o uso das funções de cada camada</li>
      <li>Entendi o processo para colocar a chave da API para poder conectar ao banco de dados "spring.datasource", assim podendo informa a port, o usename e password</li>
      <li>Pude práticar melhor Injeção de Depências</li>
    <ul>
  </div>
</div>

<div>
  <h2>
    Componentes da API
  </h2>
  <div>
    <p>API possui o CRUD completo</p>
    <div>
      <h3>Metodos</h3>
      <ul>
        <li>Get</li>
        <li>Post</li>
        <li>Patch</li>
        <li>Delete</li>
      </ul>
      <h4>Por que usou o Patch ao invés do Put?</h4>
      <p>Por causa da grande diferença entre os 2 metodos, o PUT teria que trocar todos os atributos, já com o PATCH, só os atributos necessários</p>
    </div>
  </div>
</div>

<div>
  <h3>Injeção de Depências</h3>
  <p>Na Injeção de Depências pude entender, a necessidade de classes inferiores para a classe atual exemplo:</p>
  <p>Repository usa a classe JdbcTemplate, porque permite ela conversar com o banco de dados e assim sucessivamente a classe Service usar a classe Repository e Controller usar o Service na seguinte ordem</p>
  <p>Controller -> Service -> Repository -> JdbcTemplate</p>
  <p>Assim os dados chegando até o banco</p>
</div>

<div>
  <h3>Diferença entre update(), query() e execute()</h3>
  <ul>
    <li>update(): Usado para Insert, Update e Delete</li>
    <li>query(): Usado para Select</li>
    <li>execute(): Usado para criar tabela, deletar e atualizar tabela</li>
  </ul>
</div>

