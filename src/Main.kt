/**
 * 1. Data Class: Encapsulamento de Regra
 */
data class Requisito(
    val mensagemErro: String,
    val validacao: (String) -> Boolean
)

fun main() {
    // 2. Engine de Validação: Lista de Requisitos (Sem conflitos diretos)
    val requisitos = listOf(
        // R1: Tamanho Base
        Requisito("A senha deve ter pelo menos 5 caracteres.") { it.length >= 5 },

        // R2: Times do Rio ao contrário (Requisito: Sem espaços no nome invertido)
        Requisito("Deve conter um dos 4 grandes do Rio ao contrário e sem espaços.") { senha ->
            val times = listOf("flamengo", "fluminense", "vasco", "botafogo").map { it.reversed() }
            times.any { senha.contains(it, ignoreCase = true) }
        },

        // R3: Contexto - Bola de Ouro
        Requisito("Deve conter um vencedor da Bola de Ouro.") { senha ->
            val vencedores = listOf("Messi", "Ronaldo", "Cristiano", "Rodri", "Benzema", "Kaka", "Zidane")
            vencedores.any { nome -> senha.contains(nome, ignoreCase = true) }
        },

        // R4: Contexto - O Rei
        Requisito("Deve conter um dos nomes do Rei do futebol.") { senha ->
            val nomesRei = listOf("Edson", "Arantes", "Nascimento")
            nomesRei.any { nome -> senha.contains(nome, ignoreCase = true) }
        },

        // R5: História - Libertadores do Flamengo
        Requisito("Deve conter um ano de título da Libertadores do Flamengo.") { senha ->
            val anos = listOf("1981", "2019", "2022", "2024")
            anos.any { ano -> senha.contains(ano) }
        },

        // R6: Identidade Visual
        Requisito("Deve conter pelo menos um Emoji (ex: ⚽).") { senha ->
            senha.any { it.code > 127 }
        },

        // R7: Comprimento Dinâmico (Substitui o valor fixo para evitar conflitos)
        Requisito("Harmonia Técnica: O número total de caracteres da senha deve ser um número par.") { senha ->
            senha.length % 2 == 0
        }
    )

    println("⚽ --- VALIDADOR CARIOCA: VERSÃO FINAL --- ⚽")

    // 3. Loop de Interação (UX: Foco no erro atual)
    do {
        print("\nDigite sua senha: ")
        val entrada = readLine() ?: ""

        // Encontra o primeiro requisito que falha
        val erro = requisitos.firstOrNull { !it.validacao(entrada) }

        if (erro != null) {
            println("❌ ERRO: ${erro.mensagemErro}")
            if (erro.mensagemErro.contains("par")) {
                println("   (Comprimento atual: ${entrada.length})")
            }
        } else {
            println("\n🏆 PERFEITO! Senha validada sem conflitos técnicos.")
        }

    } while (erro != null)
}