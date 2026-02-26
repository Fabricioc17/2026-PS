#=================================
# SISTEMA DE APROVAÇÃO DE ALUNOS
#=================================
#Disciplina Programação de sistemas (Ps)
#Aula 04 Revisao Variaveis, tipos e controle de fluxo
#Autor Fabricio C
#Data 24/02/2026
#Repositoria
#===============================
#
#
#Descrição 
#Este programa processa a nota dos alunos
#E mostra a situação de cada auluno Aprovado Recuperação Reprovado
#Conceitos utilizados: Variaveis
#Estruturas de seleção e estrutura de repetição
#==============================
# -------ENTRADA DE DADOS------
print("== Sistema de aprovação de alunos==")
print() # linha em branco para organizar a saida 
nome = input("Digite seu nome: ") #str texto
nota = float (input("Digite a nota 1 (0 a 10): "))# float - decimal
notaa = float (input("Digite a nota 1 (0 a 10): "))#float - decimal
#----Processamento-----
media= (nota + notaa) / 2 #Operador aritmeticos: soma e divisão
print()
print (f"Aluno    :     {nome}")
print (f"nota    :     {nota :.1f}")
print (f"notaa    :     {notaa:.1f}")
print (f"Media    :     {media:.2f}")#:.lf = exibe numeros com 2 casas decimais 
#----Decisao------
if media >=6.0:
    situacao = "APROVADOOO"
elif media >=4.0:
    situacao = "RECUPERAÇAOO"
else:
    situacao = "REPROVADO MELHORE"

print (f"Situação: {situacao}")
print("-" * 30)


