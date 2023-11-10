mysite07: frontend

1.  설치
    1)  개발툴
        $ npm i -D webpack webpack-cli webpack-dev-server css-loader style-loader sass-loader node-sass babel-loader @babel/core @babel/preset-env @babel/preset-react @babel/plugin-transform-runtime @babel/plugin-syntax-throw-expressions case-sensitive-paths-webpack-plugin concurrently

    2)  라이브러리
        $ npm i react react-dom prop-types react-addons-update react-modal styled-component react-router react-router-dom


2.  설정
    1)  webpack.config.js
    2)  babel.config.json


3.  스트립팅
    "scripts": {
        "build": "npm install && npx webpack --config config/webpack.config.js --progress --mode production",
        "dev": "npx webpack serve --config config/webpack.config.js --progress --mode development"
    }


4.  테스트 서버 실행
    $ npm run dev