# S3Transit: Envio Simples para Buckets S3 AWS

Bem-vindo ao repositório do S3Transit, um microserviço dedicado ao envio simplificado de arquivos para os buckets do Amazon S3. Este projeto foi desenvolvido utilizando as seguintes tecnologias:

- **Java 17:** A linguagem de programação principal para o desenvolvimento do serviço.
- **Spring Boot 3.2.0:** Utilizado como framework para facilitar a configuração e implementação do serviço.
- **Lombok:** Uma biblioteca Java que ajuda a reduzir a verbosidade do código, promovendo a escrita de código mais limpa e concisa.
- **Docker:** Utilizado para empacotar o serviço em um contêiner, proporcionando portabilidade e facilidade de implantação.
- **AWSSDK 2.21.37:** Biblioteca oficial da AWS SDK para Java, utilizada para integrar o serviço com os serviços S3 da AWS.

## Funcionalidades Principais

- **Envio Simples para S3:** Transfira facilmente seus arquivos para os buckets do Amazon S3.
- **Configuração Descomplicada:** Utilize o arquivo `application.yml` para configurar as opções do serviço de forma intuitiva.
- **Compatibilidade com Docker:** Execute o serviço de envio para S3 dentro de um contêiner Docker para uma fácil integração e portabilidade.

## Como Usar

### Pré-requisitos

Antes de começar, certifique-se de ter instalado o Docker em sua máquina.

### Configuração

1. Abra o arquivo `application.yml` e ajuste as configurações conforme necessário para o seu ambiente.

```yaml
# Exemplo de Configuração
aws:
  access-key: SUA_CHAVE_DE_ACESSO_AWS
  secret-key: SUA_CHAVE_SECRETA_AWS
  region: SUA_REGIAO_AWS
s3:
  bucket-name: NOME_DO_SEU_BUCKET
```

2. Salve as alterações no arquivo `application.yml`.

### Execução com Docker

1. Certifique-se de estar no diretório raiz do projeto.

2. Construa a imagem Docker:

```bash
docker build -t nome-do-servico-s3 .
```

3. Execute o contêiner:

```bash
docker run -d nome-do-servico-s3
```

Isso é tudo! Seu serviço de envio para o S3 estará em execução e pronto para receber arquivos.

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests para melhorias, correções de bugs ou novas funcionalidades.

Esperamos que este micro serviço torne mais fácil e eficiente o processo de envio de arquivos para os buckets do S3 AWS. Obrigado por usar este projeto!