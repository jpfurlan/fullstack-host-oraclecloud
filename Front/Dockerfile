# 1. Especifica a imagem base do Node.js. A tag '14' refere-se à versão do Node.js que você está usando.
FROM node:14 AS build-stage

# 2. Define o diretório de trabalho dentro do container para /app.
WORKDIR /app

# 3. Copia os arquivos 'package.json' e 'package-lock.json' (se disponível) para o diretório de trabalho.
COPY package*.json /app/

# 4. Executa o comando 'npm install' para instalar as dependências do projeto Angular.
RUN npm install

# 5. Copia todos os arquivos do projeto Angular para o diretório de trabalho no container.
COPY . /app

# 6. Executa o comando 'npm run build' para construir o aplicativo Angular para produção.
RUN npm run build

# 7. Inicia uma nova etapa de construção com uma imagem Nginx para servir o aplicativo Angular.
FROM nginx:stable-alpine AS production-stage

# 8. Copia os arquivos de construção do estágio anterior para o diretório de conteúdo do Nginx.
COPY --from=build-stage /app/dist/lista /usr/share/nginx/html

# 9. Expõe a porta 80 para permitir o acesso ao container.
EXPOSE 80

# 10. Define o comando para iniciar o Nginx e mantê-lo em execução em primeiro plano.
CMD ["nginx", "-g", "daemon off;"]
