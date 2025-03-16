/* Explorando os Recursos de IA Generativa com Copilot e OpenAI */

// 1. Instale as dependências necessárias
// npm install openai dotenv express cors

require('dotenv').config();
const express = require('express');
const cors = require('cors');
const { Configuration, OpenAIApi } = require('openai');

const app = express();
const port = process.env.PORT || 3000;

		app.use(express.json());
		app.use(cors());

		const configuration = new Configuration({
	apiKey: process.env.OPENAI_API_KEY,
});
		const openai = new OpenAIApi(configuration);

// 2. Criando uma API para interagir com OpenAI
app.post('/generate', async (req, res) => {
		try {
		const { prompt } = req.body;
    const response = await openai.createCompletion({
	model: 'text-davinci-003',
			prompt: prompt,
			max_tokens: 100,
});
		res.json({ response: response.data.choices[0].text });
		} catch (error) {
		res.status(500).json({ error: error.message });
		}
		});

// 3. Rota de Teste
		app.get('/', (req, res) => {
		res.send('Explorando os Recursos de IA Generativa com Copilot e OpenAI');
});

		app.listen(port, () => {
		console.log(`Servidor rodando na porta ${port}`);
		});

// 4. Para rodar o projeto:
// node server.js
