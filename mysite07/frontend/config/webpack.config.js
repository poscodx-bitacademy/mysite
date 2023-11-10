const path = require('path');
const CaseSensitivePathsPlugin = require('case-sensitive-paths-webpack-plugin');

module.exports = (env) => ({
    mode: "none",
    entry: path.resolve('src/index.js'),
    output: {
        path: path.resolve('../backend/src/main/resources'),
        filename: 'assets/js/main.js',
        assetModuleFilename: 'assets/images/[hash][ext]'
    },
    module: {
        rules: [{
            test: /\.(png|gif|jpe?g|svg|ico|tif?f|bmp)$/i,
            type: 'asset/resource'
        }, {
            test: /\.(sa|sc|c)ss$/i,
            use: [
                'style-loader',
                {loader: 'css-loader', options: {modules: true}},
                'sass-loader'
            ]
        }, {
            test: /\.js$/,
            exclude: /node_modules/,
            loader: 'babel-loader',
            options: {
                configFile: path.resolve('config/babel.config.json')
            }
        }]
    },
    plugins: [
        new CaseSensitivePathsPlugin()
    ],
    devtool: "eval-source-map",
    devServer: {
        host: "0.0.0.0",
        port: 9090,
        proxy: {
            '/api': 'http://localhost:8080',
            '/assets/gallery': 'http://localhost:8080'
        },
        liveReload: true,
        hot: false,
        compress: true,
        static: {
            directory: path.resolve('./public')
        },
        historyApiFallback: true
    }    
});