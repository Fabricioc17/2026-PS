# ==========================================================
# SISTEMA DE PET SHOP - REQUISITOS AULA 23
# ==========================================================
class Pet:
    def __init__(self, nome, especie, idade, raca, peso, nome_dono, vacinado):
        self.nome = nome
        self.especie = especie
        self.idade = idade
        self.raca = raca
        self.peso = peso
        self.nome_dono = nome_dono  # Corrigido: antes estava self.nomedono
        self.vacinado = vacinado

    def exibir_dados(self):
        status_vacina = "Sim" if self.vacinado else "Não"
        print(f"Nome: {self.nome} | Espécie: {self.especie} | Dono: {self.nome_dono} | Vacina: {status_vacina}")

lista_pets = []

def salvar_dados():
    arquivo = open("dados_pets.txt", "w", encoding="utf-8")
    for p in lista_pets:
        linha = f"{p.nome};{p.especie};{p.idade};{p.raca};{p.peso};{p.nome_dono};{p.vacinado}\n"
        arquivo.write(linha)
    arquivo.close()
    print("\n[OK] Dados salvos em dados_pets.txt")

def carregar_dados():  # Corrigido: faltavam os parênteses () e os dois pontos :
    try:
        arquivo = open("dados_pets.txt", "r", encoding="utf-8")
        for linha in arquivo: 
            item = linha.strip().split(";")
            if len(item) == 7:
                nome = item[0]
                especie = item[1]  # Corrigido: antes estava capturando item[0] de novo
                idade = int(item[2])
                raca = item[3]
                peso = float(item[4])
                dono = item[5]
                vacina = item[6] == "True"
                p = Pet(nome, especie, idade, raca, peso, dono, vacina)
                lista_pets.append(p)
        arquivo.close()
    except FileNotFoundError:  # Corrigido: boa prática tratar o erro específico de arquivo inexistente
        pass

# Executa a carga inicial de dados ao iniciar o programa
carregar_dados()

while True:
    print("\n--- MENU HOTEL PET 2026 ---")
    print("1 - Cadastrar novo pet")
    print("2 - Listar pets")
    print("0 - Sair")
    
    opcao = input("Escolha uma opção: ")

    if opcao == "1":
        print("\n--- Cadastro ---")
        n = input("Nome: ")
        e = input("Espécie: ")
        i = int(input("Idade: "))
        r = input("Raça: ")
        p = float(input("Peso: "))
        d = input("Nome do Dono: ")
        v = input("Vacinado (s/n)? ").lower() == "s"
        novo_pet = Pet(n, e, i, r, p, d, v)
        lista_pets.append(novo_pet)
        print("Pet cadastrado com sucesso!")

    elif opcao == "2":
        print("\n--- Pets Cadastrados ---")
        if len(lista_pets) == 0:
            print("Nenhum pet encontrado.")
        else:
            for p in lista_pets:
                p.exibir_dados()

    elif opcao == "0":
        salvar_dados()
        print("Saindo do sistema...")
        break
    
    else:
        print("Opção inválida!")
