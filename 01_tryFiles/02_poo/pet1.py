"""
=======================================================================
# ARQUIVO    : pet.py
# Disciplina : Programação de Sistemas (2026-2)
# Aula       : Aula 20 - Por que POO?
# Autor      : [SEU NOME]
# Conceitos  : Classe, objeto, atributos, métodos, encapsulamento
# Atividade  : Classe Pet completa
=======================================================================
"""

class Pet:
    def __init__(self, nome, especie, idade, raca, peso, nome_dono, vacinado):
        """
        Método construtor atualizado com novos atributos (Atividade 1).
        """
        self.nome = nome
        self.especie = especie
        self.idade = idade
        self.raca = raca
        self.peso = peso
        self.nome_dono = nome_dono
        self.vacinado = vacinado  # Booleano: True ou False
        self.hospedado = False

    def exibir_dados(self):
        """Exibe todos os dados do pet, incluindo os novos atributos."""
        print(f"\n--- Dados do Pet: {self.nome} ---")
        print(f"Espécie: {self.especie} | Raça: {self.raca}")
        print(f"Idade: {self.idade} anos | Peso: {self.peso}kg")
        print(f"Dono: {self.nome_dono}")
        print(f"Vacinado: {'Sim' if self.vacinado else 'Não'}")
        print(f"Hospedado agora: {'Sim' if self.hospedado else 'Não'}")

    def registrar_entrada(self):
        """Registra entrada verificando se já está no hotel."""
        if self.hospedado:
            print(f"Aviso: {self.nome} já está hospedado no hotel!")
        else:
            self.hospedado = True
            print(f"Check-in realizado: {self.nome} entrou no hotel.")

    def registrar_saida(self):
        """Registra saída verificando se o pet está no hotel."""
        if not self.hospedado:
            print(f"Aviso: {self.nome} não pode sair pois não está hospedado.")
        else:
            self.hospedado = False
            print(f"Check-out realizado: {self.nome} saiu do hotel.")

    def calcular_diaria(self):
        """Calcula o valor da diária com base na idade."""
        if self.idade <= 3:
            return 50.00
        elif 4 <= self.idade <= 10:
            return 60.00
        else:
            return 75.00

    def verificar_vacinacao(self):
        """Verifica o status da vacina."""
        if self.vacinado:
            print(f"Status de {self.nome}: Vacinação em dia.")
        else:
            print(f"Atenção: Vacinação de {self.nome} está pendente.")

    def atualizar_peso(self, novo_peso):
        """Atualiza o peso do pet."""
        print(f"Peso de {self.nome} atualizado de {self.peso}kg para {novo_peso}kg.")
        self.peso = novo_peso

    def emitir_resumo(self):
        """Exibe um resumo geral consolidado."""
        valor = self.calcular_diaria()
        status_H = "Sim" if self.hospedado else "Não"
        status_V = "Em dia" if self.vacinado else "Pendente"
        
        resumo = (
            f"\n========== RESUMO DO PET ==========\n"
            f"PET: {self.nome} ({self.especie}/{self.raca})\n"
            f"IDADE: {self.idade} anos | PESO: {self.peso}kg\n"
            f"DONO: {self.nome_dono}\n"
            f"VACINA: {status_V} | HOSPEDADO: {status_H}\n"
            f"VALOR DA DIÁRIA: R$ {valor:.2f}\n"
            f"===================================="
        )
        print(resumo)

# ==================================================================
# TESTES DA CLASSE (Atividade Final)
# ==============================================================================

# Criando 3 objetos Pet com diferentes dados
pet1 = Pet("Rex", "Cachorro", 5, "Labrador", 30.5, "Ana", True)
pet2 = Pet("Fifi", "Gato", 2, "Siamês", 4.2, "Carlos", False)
pet3 = Pet("Thor", "Cachorro", 12, "Poodle", 8.0, "Bia", True)

# --- Testando Pet 1 ---
pet1.exibir_dados()
pet1.registrar_entrada()
pet1.registrar_entrada() # Teste de aviso (já hospedado)
pet1.emitir_resumo()

# --- Testando Pet 2 ---
pet2.verificar_vacinacao()
pet2.atualizar_peso(4.5)
pet2.registrar_saida() # Teste de aviso (não está hospedado)

# --- Testando Pet 3 ---
pet3.registrar_entrada()
pet3.emitir_resumo()
