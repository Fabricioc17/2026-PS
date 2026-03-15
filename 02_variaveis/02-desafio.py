# Nome: Fabricio Candido Ferreira
# Disciplina: Programação de Sistemas
# Data: 26/02/2026
# Descrição:
# Programa que pede o nome e a quantidade de 3 produtos.
# Depois ele verifica a situação do estoque e mostra um relatórioo.

print("<<<< Sistema de Estoque >>>>")
print()

# lista onde os produtos serão guardados
produtos = []

# repetir 3 vezes para cadastrar 3 produtos
for i in range(3):

    # pedir o nome do produto
    nome = input("Digite o nome do produto: ")

    # pedir a quantidade no estoque
    quantidade = int(input("Digite a quantidade: "))

    # Ver a situação do estoque
    if quantidade < 5:
        status = "Quantidade Crítica"
    elif quantidade <= 20:
        status = "Quantidade Adequada"
    else:
        status = "Excesso de Estoque"

    # guardar as informações do produto na lista
    produtos.insert(i, (nome, quantidade, status))

    print()

print("===== RELATÓRIO =====")

# mostrar todos os produtos cadastrados
for nome, quantidade, status in produtos:
    print("Produto:", nome)
    print("Quantidade:", quantidade)
    print("Situação:", status)
    print()