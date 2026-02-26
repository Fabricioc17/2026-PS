#Arquivo 01b-debug.py
nome = input("digite o nome do aluno: ")
#O jeito certo de escrever é input

nota1 = float (input(" Digite a nota"))
nota2 = float (input(" Digite a nota"))

media = (nota1 + nota2) / 2
#Precisa do parenteses
if media >=6.0:
    situacao = "APROVADOOO"
elif media >=4.0:
    situacao = "RECUPERAÇAOO"
else:
    situacao = "REPROVADO MELHORE"
print(f"aluno: {nome} | Média: {media:.2f} | Situação: {situacao}")
# O jeito certo é print