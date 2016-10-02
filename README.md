# Projeto_Exemplo_DSD_JSF_JPA
Projeto de exemplo para as aulas de DSD da Metodista

Instruções para clonar o projeto no NetBeans:

No Netbeans, clicar no menu EQUIPE (TEAM em Inglês) e depois em GIT/Clonar, adicionar a 
url https://github.com/Atanes/Projeto_Exemplo_DSD_JSF_JPA.git no campo "URL do Repósitório", 
deixar usuario e senha em branco, depois é só clicar em próximo/next até o final do processo; 

Fazer o download do arquivo jandex-2.0.3.final.jar de https://mvnrepository.com/artifact/org.jboss/jandex/2.0.3.Final
copiar e colar esse arquivo na pasta: C:\Program Files\NetBeans 8.0.2\java\modules\ext\hibernate4

Nas propriedades do projeto, procurar as bibliotecas do hibernate, clicar em editar, procurar a classe Jandex
no diretorio C:\Program Files\NetBeans 8.0.2\java\modules\ext\hibernate4 e adicionar no projeto.

Trocar a classe de conexao do PostgreSQL pela do Banco de Dados que você estiver usando (Oracle, por exemplo!)

Alterar o arquivo persistence.xml para:

<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.0" xmlns="http://java.sun.com/xml/ns/persistence" 
                           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
                           xsi:schemaLocation="http://java.sun.com/xml/ns/persistence 
                           http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd">
  <persistence-unit name="ProfessorPU">
    <provider>org.hibernate.ejb.HibernatePersistence</provider>
    <properties>
            <property name="javax.persistence.jdbc.url"
                      value="URL DO BANCO QUE VOCE ESTIVER USANDO" />
                        (Exemplo para o banco Oracle da Univeridade: "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=10.20.250.13)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=DBFACET)))")
            <property name="javax.persistence.jdbc.user"
                      value="USUARIO PARA ACESSO AO BANCO" />
            <property name="javax.persistence.jdbc.password"
                      value="SENHA PARA ACESSO AO BANCO" />
            <property name="javax.persistence.jdbc.driver"
                      value="DRIVER DO BANCO QUE VOCE ESTIVER USANDO" />
                        (Exemplo para o banco Oracle: "oracle.jdbc.OracleDriver")
            <property name="hibernate.dialect"
                      value="DIALETO DO BANCO QUE VOCE ESTIVER USANDO"/>
                        (Exemplo para o banco Oracle: "org.hibernate.dialect.Oracle9Dialect")
            <property name="hibernate.hbm2ddl.auto"
                      value="update" />
            <property name="hibernate.show_sql" value="true" />
            <property name="hibernate.format_sql" value="true" />          
        </properties>
  </persistence-unit>
</persistence>

Clicar sobre o projeto com o botão direito do mouse e depois selecionar "Limpar e Construir";

Executar o projeto.
