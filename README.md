# ⚽ The Ultimate Carioca Password Game
### Motor de Validação Dinâmica em Kotlin

Este projeto é um validador de senhas inspirado no famoso *"The Password Game"*, desenvolvido para exercitar conceitos de **Orientação a Objetos (POO)** e **Programação Funcional (Lambdas)** na disciplina de Engenharia de Software.



## 🛠️ Tecnologias e Conceitos
- **Linguagem:** Kotlin
- **Paradigma:** Funcional (Lambdas) e Imperativo.
- **Data Classes:** Para estruturação imutável das regras.
- **SOLID:** Aplicação do Princípio do Aberto/Fechado (Open/Closed Principle).

## 📋 Regras do Desafio
Para validar a senha, o usuário deve cumprir sequencialmente:

1. **Segurança:** Mínimo de 5 caracteres.
2. **Localização:** Conter um dos 4 grandes do Rio (Flamengo, Fluminense, Vasco ou Botafogo) **escrito ao contrário**.
3. **Prestígio:** Conter o nome de um vencedor da **Bola de Ouro**.
4. **Realeza:** Conter um dos nomes do Rei Pelé (**Edson, Arantes ou Nascimento**).
5. **História:** Conter um ano de título da **Libertadores do Flamengo** (1981, 2019, 2022 ou 2024).
6. **Visual:** Conter pelo menos um **Emoji**.
7. **Harmonia:** O comprimento total da senha deve ser um **número par**.

## 🏗️ Lógica de Implementação
O sistema utiliza uma `List<Requisito>` que é percorrida a cada entrada do usuário. O método `.firstOrNull` é utilizado para encontrar o primeiro critério não satisfeito, garantindo uma interface limpa onde o usuário resolve um problema de cada vez (Foco em UX).

---
**Desenvolvido como exercício acadêmico de Engenharia de Software (5º Ano).**
