# Sistema de Biblioteca em Java

Este projeto implementa um sistema de gerenciamento de biblioteca utilizando diversos padrões de design para promover um código limpo, modular e de fácil manutenção.

## Padrões de Design Utilizados

O sistema de biblioteca foi arquitetado utilizando os seguintes padrões de design:

### Singleton

O padrão Singleton é aplicado na classe `Repositorio`. Este padrão garante que apenas uma instância da classe `Repositorio` seja criada durante a execução do programa, fornecendo um ponto de acesso global a todos os dados do sistema (usuários, livros, etc.). Isso é essencial para manter a consistência dos dados da biblioteca.

### Command

O padrão Command é amplamente utilizado para encapsular as requisições como objetos.
* **Interface `IComando`**: Define a interface para todos os comandos que podem ser executados no sistema.
* **Implementações de Comando**: Classes como `EmprestarComando`, `ReservarComando`, `DevolverComando`, `ConsultarLivroComando`, `ConsultarUsuarioComando`, `ConsultarNotificacaoComando`, `RegistrarObservadorComando`, e `SairComando` implementam esta interface, cada uma encapsulando uma operação específica do sistema.
* **Invoker (`InterfaceUsuario`)**: A classe `InterfaceUsuario` atua como o invocador. Ela recebe a entrada do usuário, cria o objeto de comando apropriado através da `FabricaParametros`, e o executa, desacoplando o cliente (usuário) da ação a ser executada.

### Strategy

O padrão Strategy é utilizado para definir uma família de algoritmos, encapsulá-los e torná-los intercambiáveis.
* **Interface `IRegraEmprestimo`**: Declara a interface comum para todos os algoritmos de regras de empréstimo.
* **Estratégias Concretas**: `RegraAluno` e `RegraProfessor` são implementações concretas que definem as regras específicas para empréstimos de livros para alunos (graduação e pós-graduação) e professores, respectivamente.
* **Contexto (`Usuario`)**: A classe `Usuario` contém uma referência a uma `IRegraEmprestimo` e delega a ela a decisão sobre se um usuário pode ou não pegar um livro emprestado, permitindo que as regras de empréstimo sejam facilmente modificadas ou adicionadas sem alterar a classe `Usuario`.

### Observer

O padrão Observer é empregado para estabelecer uma dependência um-para-muitos entre objetos, de modo que quando um objeto (o sujeito) muda de estado, todos os seus dependentes (os observadores) são notificados e atualizados automaticamente.
* **Interface `ISubject`**: Define o contrato para os objetos que podem ser observados (sujeitos).
* **Sujeito Concreto (`Livro`)**: A classe `Livro` implementa `ISubject` e mantém uma lista de observadores. Quando o número de reservas de um livro atinge um certo limite (dois ou mais), ele notifica seus observadores.
* **Interface `IObservadorReserva`**: Define a interface para os observadores.
* **Observador Concreto (`Professor`)**: A classe `Professor` implementa `IObservadorReserva`. Professores podem "observar" livros e são notificados quando o número de reservas de um livro excede o limite, incrementando um contador de notificações.

## Como Usar o Sistema

O sistema é executado através da classe `InterfaceUsuario`.

Para iniciar o sistema, compile e execute a classe `InterfaceUsuario.java`. O programa carregará dados iniciais na memória e exibirá a mensagem de boas-vindas: "Oi, o sistema está rodando!".

### Comandos Disponíveis:

Os comandos são inseridos no console, seguidos pelos parâmetros necessários.

* **`emp [código do usuário] [código do livro]`**: Realiza o empréstimo de um livro para um usuário.
    * Exemplo: `emp 123 100` (Empresta o livro de código "100" para o usuário "123").

* **`res [código do usuário] [código do livro]`**: Realiza a reserva de um livro para um usuário.
    * Exemplo: `res 123 301` (Reserva o livro de código "301" para o usuário "123").

* **`dev [código do usuário] [código do livro]`**: Registra a devolução de um livro por um usuário.
    * Exemplo: `dev 123 100` (Registra a devolução do livro "100" pelo usuário "123").

* **`liv [código do livro]`**: Consulta as informações de um livro, incluindo o número de reservas, nomes dos usuários em reserva e exemplares.
    * Exemplo: `liv 100` (Consulta informações do livro de código "100").

* **`usu [código do usuário]`**: Consulta os empréstimos e reservas de um usuário.
    * Exemplo: `usu 123` (Consulta empréstimos e reservas do usuário "123").

* **`ntf [código do usuário]`**: Consulta as notificações de reserva para um usuário (específico para usuários que implementam `IObservadorReserva`, como professores).
    * Exemplo: `ntf 100` (Consulta notificações do professor de código "100").

* **`obs [código do usuário] [código do livro]`**: Registra um usuário como observador de um livro. Este usuário será notificado sobre mudanças no status de reserva do livro.
    * Exemplo: `obs 100 301` (Professor "100" passa a observar o livro "301").

* **`sai`**: Encerra o sistema.
    * Exemplo: `sai`

Para os comandos com múltiplos parâmetros, a `FabricaParametros` lida com a criação do objeto `CarregadorParametros` adequado com base no número de argumentos fornecidos.