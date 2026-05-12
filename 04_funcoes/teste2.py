ARQUIVO = "usuarios.txt"

# Criar arquivo se não existir
def criar_arquivo():
    try:
        with open(ARQUIVO, "x"):
            pass
    except FileExistsError:
        pass

# Cadastrar usuário
def cadastrar():
    usuario = input("Novo usuário: ")
    senha = input("Nova senha: ")  # Sem ocultar a senha

    with open(ARQUIVO, "a") as f:
        f.write(f"{usuario};{senha}\n")

    print("Usuário cadastrado com sucesso!")

# Listar usuários
def listar():
    with open(ARQUIVO, "r") as f:
        print("\nUsuários cadastrados:")
        for linha in f:
            if ";" in linha:
                usuario, _ = linha.strip().split(";")
            print(f"- {usuario}")

# Login (validação)
def login():
    usuario = input("Usuário: ")
    senha = input("Senha: ")  # Sem ocultar a senha

    with open(ARQUIVO, "r") as f:
        for linha in f:
            if ";" in linha:
                u, s = linha.strip().split(";")
                if usuario == u and senha == s:
                    print("Login realizado com sucesso!")
                    return

    print("Usuário ou senha inválidos!")

# Menu principal
def menu():
    criar_arquivo()

    while True:
        print("\n1 - Cadastrar")
        print("2 - Listar")
        print("3 - Login")
        print("4 - Sair")

        opcao = input("Escolha: ")

        if opcao == "1":
            cadastrar()
        elif opcao == "2":
            listar()
        elif opcao == "3":
            login()
        elif opcao == "4":
            print("Saindo...")
            break
        else:
            print("Opção inválida!")

# Executar sistema
menu()