 #=================#==============================
# SISTEMA DE PEDIDOS DE UM RESTAURANTE
# ===============================================
# Disciplina : Programação de Sistemas (PS)
# Aula       : 12 - criação do projeto.
# Autor      : Felipe Dalzoto e Fabricio Candido
# Data       : 28/03/2026
# Repositorio: https://github.com/FeliDalzoto123/2026-PS
# ================================================
#
# DESCRIÇÃO:
# criar um sistema para cadastrar um restaurante, seus pratos e 
# gerenciar os pedidos feitos pelos clientes. 
# =================================================

ARQUIVO = "dados.txt"

# Criar um arquivo txt para armazenar os dados.
def criar_arquivo():
    try:
        with open(ARQUIVO, "w") as f:
            f.write("Cardapio: \n")
            f.write("Pedidos: \n")
    except FileExistsError:
        print("O arquivo já existe.")
        
# Cadastrar o cardapio do retaurante
def cadastrar_cardapio():
    prato = input("Digite o nome do prato: ")
    preco = float(input("Digite o preço do prato: "))
    with open(ARQUIVO, "a") as f:
        f.write(f"Prato: {prato} - R$ {preco:.2f}\n")
        print("Prato cadastrado com sucesso!")

# Gerenciar os pedidos feitos
def gerenciar_pedidos():
    cliente = input("Digite o nome do cliente: ")
    prato = input("Digite o nome do prato pedido: ")
    with open(ARQUIVO, "a") as f:
        f.write(f"Pedido: {cliente} - {prato}\n")
        print("Pedido registrado!")

# Pagamento
def pagamento():
    print ("\n=== PAGAMENTO ===")
    print ("1-Pix")
    print ("2-Cartão")
    print ("3-Boleto")    
    opcao = input("Escolha a forma de pagamento: ")

    try:
        opcao = opcao.strip()
    except ValueError:
        print("Opção inválida, tente novamente.")
        return "Desconhecido"
    if opcao == "1":
        print ("Pagamento via Pix realizado com sucesso!")
        return "Pix"
    elif opcao == "2":
        print("Pagamento no cartão aprovado!")
        return "Cartão"
    elif opcao == "3":
        print ("Boleto gerado!")
        return "Boleto"
    else:
        print("Opção inválida")
        return "Desconhecido"
    
# Menu Principal
def menu():
    criar_arquivo()
    
    while True:
        print("\n=== SISTEMA DE PEDIDOS DE UM RESTAURANTE ===")
        print()
        print("\n1 - Cadastrar Cardápio")
        print("2 - Gerenciar Pedidos")
        print("3 - Pagamento")
        print("4 - Sair")
        opcao = input("Escolha uma opção: ")
        try:
            opcao = opcao.strip()
        except ValueError:
            print("Opção inválida, tente novamente.")
            continue
        if opcao == "1":
            cadastrar_cardapio()
        elif opcao == "2":
            gerenciar_pedidos()
        elif opcao == "3":
            pagamento()
        elif opcao == "4":
            print("Saindo do sistema...")
            break
        else:
            print("Opção inválida, tente novamente.")
menu()
