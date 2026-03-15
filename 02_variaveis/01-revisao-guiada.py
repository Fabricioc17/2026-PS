# =====================================================
# SISTEMA DE APROVAÇÃO DE ALUNOS
# =====================================================

# Disciplina : Programação de Sistemas (PS)
# Aula       : 04 – Revisão: Variáveis, Tipos e Controle de Fluxo
# Autor      : Fabricio Candido Ferreira
# Data       : 08/03/2026
# Repositório: https://github.com/Fabricio17/2026-PS

# =====================================================

# DESCRIÇÃO:
# Este programa processa as notas de uma turma e determina
# a situação de cada aluno (Aprovado, Recuperação ou Reprovado).
# Conceitos utilizados: variáveis, tipos de dados, operadores,
# estruturas de seleção e estruturas de repetição.

# =====================================================

# ---- ENTRADA DE DADOS ----

print("=== Sistema de Aprovação de Alunos ===")
print()  # linha em branco para organizar a saída

nome = input("Digite o nome do aluno: ")  # str - texto
nota1 = float(input("Digite a nota 1 (0 a 10): "))  # float - decimal
nota2 = float(input("Digite a nota 2 (0 a 10): "))  # float - decimal
# ---- PROCESSAMENTO ----

media = (nota1 + nota2) / 2  # operador aritmético: soma e divisão

print()
print(f"Aluno   : {nome}")
print(f"Nota 1  : {nota1:.1f}")
print(f"Nota 2  : {nota2:.1f}")
print(f"Média   : {media:.2f}")  # :.2f = exibe com 2 casas decimais
# ---- DECISÃO ----

if media >= 6.0:                                # condição principal
    situacao = "✅ Aprovado"
elif media >= 4.0:                              # condição alternativa (só verificada se a anterior for falsa)
    situacao = "⚠️ Recuperação"
else:                                           # caso nenhuma condição anterior seja verdadeira
    situacao = "❌ Reprovado"

print(f"Situação: {situacao}")
print("-" * 40)  # linha separadora: repete o caractere "-" 40 vezes