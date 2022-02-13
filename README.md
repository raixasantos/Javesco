# Banco Javesco

![alt text](https://github.com/imetropoledigital/imd0040-trabalho-final-javesco/blob/main/resources/Javesco.png)
Sistema bancário simulador de empréstimos.

## [Link para vídeo de apresentação](https://www.youtube.com/watch?v=A5EAk_fWgFY&ab_channel=AngeloSales)

## Descrição do trabalho

O projeto simula as execuções de empréstimos realizados nos Bancos e tem como objetivo praticar os ensinamentos obtidos na disciplina de Linguagem de Programação II do Curso de BTI na UFRN, Campus Natal. O projeto é desenvolvido na linguagem de programação Java e aplica fundamentos da programação orientada a objetos.

### Organização dos arquivos
##### Banco.java
> Classe principal que executará o método menu() de InterfaceGŕafica.

##### InterfaceGrafica.java
> Classe que imprime o menu e suas opções e dadas escolhas do cliente serão passadas para o GerenciadorEmprestimo. 

##### GerenciadorEmprestimo.java
> Classe gerenciadora que validará os emprestimos solicitados e gerará a simulação dos emprestimos.

##### Emprestimo.java
> Classe com atributos dos emprestimos solicitados e simulados.

##### TipoEmprestimo.java
> Enum para os diferentes tipos de emprestimo.

##### Cliente.java
> Classe com os atributos do usuário.

## Diagrama de classes
![alt text](https://github.com/imetropoledigital/imd0040-trabalho-final-javesco/blob/main/resources/Simulador%20de%20Financiamento.jpg)

## Instruções para build e execução
No endereço src/main/java/ será possível compilar e executar o projeto pelo seguinte comando :
```
javac Banco.java && java Banco
```

Para executar o projeto com gradle execute o seguinte comando:
```
./gradlew
```
E depois na arquiva src/main/java/Banco.java será possível selecionar a opção de 'run' digitando 'shift+f10'.


### Primeiro Repositorio
Os primeiros commits foram enviados para o seguinte repositório pessoal: [Javesco](https://github.com/raixasantos/Javesco).
