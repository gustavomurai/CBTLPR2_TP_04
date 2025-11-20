# 🧾 Trabalho Prático 04 – Java + SQL Server + JDBC  
**Disciplina:** CBTLPR2 (Java) – ADS 471  
**Instituição:** IFSP – Campus Cubatão  

Projeto realizado por Gustavo Murai e Igor Murai

Este projeto tem como objetivo integrar uma aplicação Java (com Swing) a um banco de dados SQL Server utilizando JDBC.  
A aplicação permite pesquisar funcionários pelo nome, visualizar seus dados e navegar entre registros utilizando botões *Anterior* e *Próximo*.

---

## 📌 Funcionalidades do Sistema

- Interface gráfica construída com **Java Swing**  
- Campo para **buscar funcionário pelo nome**  
- Preenchimento automático dos campos:
  - Nome
  - Salário
  - Cargo
- Navegação completa entre registros:
  - 👉 Botão **Anterior**
  - 👉 Botão **Próximo**
- Conexão com SQL Server utilizando **JDBC**
- Consulta via **PreparedStatement** e uso de `LIKE` no filtro

---

## 🏗️ Arquitetura do Banco de Dados

O projeto utiliza o banco **aulajava**, contendo duas tabelas relacionadas:

### 📄 **Tabela: tbcargos**
| Campo       | Tipo      | Descrição                 |
|-------------|-----------|---------------------------|
| cod_cargo   | smallint  | Identificador do cargo    |
| ds_cargo    | char(20)  | Nome/descrição do cargo   |

### 📄 **Tabela: tbfuns**
| Campo       | Tipo        | Descrição                  |
|-------------|-------------|----------------------------|
| cod_func    | decimal(9)  | Identificador do funcionário |
| nome_func   | char(30)    | Nome completo               |
| sal_func    | money       | Salário                     |
| cod_cargo   | smallint    | Chave estrangeira → tbcargos |


