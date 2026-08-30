# -*- coding: utf-8 -*-
"""
==============================================================================
ARQUIVO: 05_EntradaDados.py
DISCIPLINA: Programação de Sistemas (2026-PS)
INSTITUIÇÃO: IFPR - Centro de Referência Ponta Grossa
PROFESSOR: Profe. Berssa (Dr. João Henrique Berssanette)
==============================================================================

OBJETIVO:
    Laboratório interativo sobre Entrada de Dados (input) e Conversão.
    Baseado integralmente no "Glossário 06 - Entrada de Dados".

CONTEÚDO PROGRAMÁTICO:
    1. Conceito: A função input() pausa o programa para ler o teclado.
    2. O Problema do Tipo: input() sempre retorna STRING (texto).
    3. Conversão (Casting): Usando int() e float() para ler números.
    4. Leitura Múltipla: Usando .split() e map() para vários valores na mesma linha.
    5. Erros Comuns: ValueError (texto onde deveria ser número).
    6. Exemplo Integrador: Calculadora de Média.

==============================================================================
"""

import sys
import time

def limpar_tela():
    """Limpa visualmente o terminal."""
    print("\n" * 5)
    print("=" * 80)

def esperar():
    """Pausa para leitura."""
    input("\n[Pressione ENTER para continuar...]")

def mostrar_codigo_didatico(codigo):
    """Exibe o código com numeração e destaque para os comentários."""
    print("\n📄 CÓDIGO EM ANÁLISE (Observe os comentários #):")
    print("-" * 80)
    linhas = codigo.strip().split('\n')
    for i, linha in enumerate(linhas):
        print(f"{i+1:02d} | {linha}")
    print("-" * 80)
    print("\n▶️  INICIANDO EXECUÇÃO PASSO A PASSO...\n")
    time.sleep(1.5)
    return linhas

def executar_linha(numero_linha, atraso=0.8):
    """Simula o processamento da linha."""
    print(f"⚙️  [Lendo Linha {numero_linha:02d}]...", end="\r")
    time.sleep(atraso)
    print(f"✅ [Executado Linha {numero_linha:02d}]   ")

# ==============================================================================
# TÓPICO 1: O BÁSICO E O TIPO STRING
# ==============================================================================
def basico_input():
    limpar_tela()
    print("🔹 TÓPICO 1: O BÁSICO DE INPUT")
    print("-" * 80)
    print("A função input() PAUSA o programa e espera o usuário digitar ENTER.")
    print("IMPORTANTE: Tudo que você digita entra como TEXTO (String).")
    print("-" * 80)

    # Baseado no Exemplo 1 e 3 do Glossário
    codigo = """# 1. Leitura simples (O programa pausa aqui)
nome = input("Digite seu nome: ")

# 2. Verificando o tipo do dado
print(f"Olá, {nome}! O tipo da variável é: {type(nome)}")

# 3. O perigo da concatenação não intencional
num = input("Digite um número: ")  # Se digitar 5...
print(f"O dobro (errado) é: {num + num}") # ...vai imprimir 55, não 10!"""

    mostrar_codigo_didatico(codigo)

    executar_linha(2, atraso=0.5)
    # A interação real acontece aqui
    nome = input("   ↳ AÇÃO USUÁRIO (Digite seu nome): ")

    executar_linha(5)
    print(f"   ↳ SAÍDA: Olá, {nome}! O tipo da variável é: {type(nome)}")
    print("   (Note que 'class str' significa String/Texto)")

    executar_linha(8)
    num = input("   ↳ AÇÃO USUÁRIO (Digite 5): ")
    
    executar_linha(9)
    print(f"   ↳ CÁLCULO: '{num}' + '{num}' = '{num + num}' (Juntou texto!)")
    print("   ↳ SAÍDA: O dobro (errado) é: " + num + num)
    
    esperar()

















# ==============================================================================
# TÓPICO 2: CONVERSÃO (CASTING)
# ==============================================================================
def conversao_casting():
    limpar_tela()
    print("🔹 TÓPICO 2: CONVERSÃO DE TIPOS (CASTING)")
    print("-" * 80)
    print("Para fazer contas, precisamos converter o texto para número.")
    print("   int()   -> Para números inteiros (10, -5, 100)")
    print("   float() -> Para números com vírgula (1.75, 10.0)")
    print("-" * 80)
    
    # Baseado no Exemplo 2 do Glossário
    codigo = """# Forma 1: Ler e depois converter
entrada = input("Ano de nascimento: ")
ano = int(entrada)

# Forma 2: Ler e converter na mesma linha (Mais comum!)
# float() aceita ponto, mas não vírgula (Use 1.80, não 1,80)
altura = float(input("Altura (metros): "))

idade = 2026 - ano
print(f"Você tem {idade} anos e {altura:.2f}m.")"""

    mostrar_codigo_didatico(codigo)

    executar_linha(2)
    entrada = input("   ↳ AÇÃO USUÁRIO (Digite seu ano de nascimento): ")
    
    executar_linha(3)
    try:
        ano = int(entrada)
        print(f"   ↳ CONVERSÃO: Texto '{entrada}' virou Inteiro {ano}")
    except ValueError:
        ano = 2000
        print("   (Valor inválido! Assumindo 2000 para continuar)")

    executar_linha(7)
    try:
        altura = float(input("   ↳ AÇÃO USUÁRIO (Digite altura ex: 1.75): "))
    except ValueError:
        altura = 1.70
        print("   (Valor inválido! Assumindo 1.70)")

    executar_linha(9)
    idade = 2026 - ano
    print(f"   ↳ CÁLCULO: 2026 - {ano} = {idade}")
    
    executar_linha(10)
    print(f"   ↳ SAÍDA: Você tem {idade} anos e {altura:.2f}m.")
    
    esperar()

# ==============================================================================
# TÓPICO 3: ERROS COMUNS (VALUE ERROR)
# ==============================================================================
def erros_comuns():
    limpar_tela()
    print("🔹 TÓPICO 3: ERROS COMUNS (VALUE ERROR)")
    print("-" * 80)
    print("O que acontece se tentarmos converter 'abc' para número?")
    print("O Python gera um ERRO e o programa para (Crash).")
    print("-" * 80)
    
    # Baseado na seção de Erros Comuns do Glossário
    codigo = """print("Tentando converter texto inválido...")
try:
    # O usuário digita "olá" onde deveria ser um número
    num = int("olá") 
    print("Sucesso!")
except ValueError:
    print("ERRO: ValueError detectado!")
    print("Não é possível transformar 'olá' em número inteiro.")"""

    mostrar_codigo_didatico(codigo)
    
    executar_linha(1)
    
    executar_linha(2)
    print("   ↳ SISTEMA: Iniciando bloco de proteção (Try)...")
    
    executar_linha(4)
    print("   ↳ TENTATIVA: int('olá')...")
    time.sleep(1)
    print("   ❌ FALHA: O Python não sabe converter letras em números.")
    
    # Pula linha 5
    executar_linha(6)
    print("   ↳ CAPTURA: O erro foi capturado pelo 'except'.")
    
    executar_linha(7)
    print("   ↳ SAÍDA: ERRO: ValueError detectado!")
    
    executar_linha(8)
    print("   ↳ SAÍDA: Não é possível transformar 'olá' em número inteiro.")
    
    print("\n💡 DICA: Sempre valide o que o usuário digita!")
    esperar()

# ==============================================================================
# TÓPICO 4: LEITURA MÚLTIPLA (SPLIT E MAP)
# ==============================================================================
def leitura_multipla():
    limpar_tela()
    print("🔹 TÓPICO 4: LEITURA DE MÚLTIPLOS VALORES")
    print("-" * 80)
    print("E se quisermos ler dois números na MESMA linha?")
    print("Usamos .split() para separar e map() para converter.")
    print("-" * 80)
    
    # Baseado no Exemplo 4 e 5 do Glossário
    codigo = """# 1. Usando split() para separar texto por espaços
texto = input("Digite 2 nomes (ex: Ana João): ")
nomes = texto.split() # Cria uma lista ['Ana', 'João']
print(f"Primeiro: {nomes[0]}, Segundo: {nomes[1]}")

# 2. Truque PRO (map): Ler e converter ao mesmo tempo
# Lê a linha -> Separa espaços -> Converte cada pedaço para int
print("Digite 2 números (ex: 10 20):")
n1, n2 = map(int, input().split())

soma = n1 + n2
print(f"Soma rápida: {soma}")"""

    mostrar_codigo_didatico(codigo)
    
    executar_linha(2)
    texto = input("   ↳ AÇÃO USUÁRIO (Digite dois nomes separados por espaço): ")
    if not texto: texto = "Ana João" # Fallback
    
    executar_linha(3)
    nomes = texto.split()
    print(f"   ↳ PROCESSAMENTO: '{texto}' virou a lista {nomes}")
    
    executar_linha(4)
    if len(nomes) >= 2:
        print(f"   ↳ SAÍDA: Primeiro: {nomes[0]}, Segundo: {nomes[1]}")
    else:
        print("   (Você digitou menos de 2 nomes, mas ok)")
    
    executar_linha(8)
    print("   (Prepare-se para digitar dois números na mesma linha)")
    
    executar_linha(9)
    entrada_nums = input("   ↳ AÇÃO USUÁRIO (ex: 10 20): ")
    try:
        n1, n2 = map(int, entrada_nums.split())
        
        executar_linha(11)
        soma = n1 + n2
        
        executar_linha(12)
        print(f"   ↳ SAÍDA: Soma rápida: {soma}")
    except:
        print("   ❌ Erro: Você precisava digitar DOIS números separados por espaço.")
    
    esperar()

# ==============================================================================
# TÓPICO 5: EXEMPLO INTEGRADOR (MÉDIA)
# ==============================================================================
def desafio_media():
    limpar_tela()
    print("🔹 DESAFIO FINAL: CALCULADORA DE MÉDIA")
    print("Integra: Input, Float, Cálculos, F-Strings e Validação Básica.")
    print("-" * 80)
    
    # Baseado no Exemplo 6 do Glossário (Nota Fiscal Simplificada adaptada para Média)
    # ou podemos usar o Exemplo 6 real do glossário se houver.
    # O Glossário 06 tem "Exemplo 6: Mini-programa — Calculadora de Média"
    
    codigo_ref = """print("--- BOLETIM ESCOLAR ---")
nome = input("Nome do Aluno: ")

# Lendo notas (convertendo para float)
n1 = float(input("Nota 1: "))
n2 = float(input("Nota 2: "))
n3 = float(input("Nota 3: "))

# Processamento
media = (n1 + n2 + n3) / 3

# Saída Formatada
print(f"Aluno: {nome}")
print(f"Média: {media:.1f}") # .1f = Uma casa decimal
print(f"Aprovado? {media >= 7.0}")"""
    
    mostrar_codigo_didatico(codigo_ref)
    
    try:
        executar_linha(1)
        print("--- BOLETIM ESCOLAR ---")
        
        executar_linha(2)
        nome = input("   Nome do Aluno: ")
        
        print("\n⚙️  [Coletando Notas]...")
        n1 = float(input("   Nota 1: "))
        n2 = float(input("   Nota 2: "))
        n3 = float(input("   Nota 3: "))
        
        print("\n⚙️  [Calculando Média]...")
        time.sleep(1)
        media = (n1 + n2 + n3) / 3
        
        print("-" * 30)
        print(f"Aluno: {nome}")
        print(f"Média: {media:.1f}")
        
        if media >= 7.0:
            print("Resultado: APROVADO ✅")
        else:
            print("Resultado: REPROVADO ❌")
        print("-" * 30)
            
    except ValueError:
        print("\n❌ ERRO: As notas precisam ser números (use ponto em vez de vírgula).")
        
    esperar()

# ==============================================================================
# MENU PRINCIPAL
# ==============================================================================
def menu_principal():
    while True:
        limpar_tela()
        print("🐍 Guia de Referência Rápida Python — by Profe. Berssa".center(80))
        print("LABORATÓRIO DE ENTRADA DE DADOS (GLOSSÁRIO 06)".center(80))
        print("=" * 80)
        print("1. O Básico: input() sempre retorna String")
        print("2. Conversão (Casting): Transformando texto em número")
        print("3. Erros Comuns: ValueError")
        print("4. Leitura Múltipla: .split() e map()")
        print("5. Desafio Integrador: Calculadora de Média")
        print("0. Sair")
        print("=" * 80)
        
        opcao = input("\nEscolha o tópico para revisar: ")
        
        if opcao == '1': basico_input()
        elif opcao == '2': conversao_casting()
        elif opcao == '3': erros_comuns()
        elif opcao == '4': leitura_multipla()
        elif opcao == '5': desafio_media()
        elif opcao == '0':
            print("\nEncerrando laboratório... Não esqueça de converter seus inputs! 👋")
            break
        else:
            print("Opção inválida!")
            time.sleep(1)

if __name__ == "__main__":
    menu_principal()