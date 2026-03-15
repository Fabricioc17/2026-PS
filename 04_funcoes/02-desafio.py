# Nome: Fabricio Candido Ferreira
# Disciplina: Programação de Sistemas
# Curso: Técnico em Informática - IFPR
# Data: 09/03/2026
# Descrição:
# Programa simples para calcular a média de um aluno
# e verificar a situação (Aprovado, Recuperação ou Reprovado).


# função que calcula a média das duas notas
def calcular_media(nota1, nota2):
    media = (nota1 + nota2) / 2
    return media


# função que verifica a situação do aluno
def verificar_situacao(media):

    if media >= 6.0:
        return "Aprovado"

    elif media >= 4.0:
        return "Recuperação"

    else:
        return "Reprovado"


# programa principal
print("<<<< Sistema de Notas >>>>")
print()

# entrada de dados
nome = input("Digite o nome do aluno: ")

nota1 = float(input("Digite a primeira nota: "))
nota2 = float(input("Digite a segunda nota: "))

# cálculo da média usando a função
media = calcular_media(nota1, nota2)

# verificar situação
situacao = verificar_situacao(media)

print()
print("Aluno:", nome)
print("Média:", media)
print("Situação:", situacao)