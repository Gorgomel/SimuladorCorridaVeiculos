# RunnerSim — Simulador de Corrida de Veículos

Aplicativo **console** em **Java 17** para simular inclusão, movimentação e manutenção de veículos (calibragem de pneus, abastecimento), com **persistência em arquivo** e **build reproduzível** via Gradle.

---

## ✨ Funcionalidades

* Inclusão/remoção de veículos dos tipos:

  * **B**icicleta, **M**otocicleta, **E**sportivo, **C**arro de passeio
* Movimentação:

  * Um veículo por **ID**, por **tipo**, ou **todos**
* Manutenção:

  * Calibrar/esvaziar **um pneu específico**
  * Calibrar/esvaziar **todos os pneus** de veículos de um tipo
* Visualização:

  * Impressão de **dados** e **“pista” ASCII**
* Persistência:

  * **Salvar/Ler** o estado do simulador em arquivo (`saves/simulador.dat`)

---

## 🛠 Requisitos

* **Java 17** (JDK)
* **Gradle Wrapper** incluído no repositório (não precisa instalar Gradle)

---

## 🚀 Como executar

### Clonar e rodar

```bash
# Linux / macOS
./gradlew clean run

# Windows (PowerShell / CMD)
.\gradlew clean run
```

O menu interativo aparecerá no terminal. Digite as opções **1..15** e siga as instruções na tela.

### Persistência (Salvar/Ler)

* Caminho padrão: `saves/simulador.dat`
* No menu:

  * **13** – Gravar veículos em arquivo
  * **14** – Ler veículos do arquivo
* **Dica:** Se a pasta `saves/` não existir, crie:

  ```bash
  mkdir saves
  ```

---

## 🧪 Testes e cobertura

```bash
# Executar testes
./gradlew test

# Relatório de cobertura
./gradlew jacocoTestReport
# Abra: build/reports/jacoco/test/html/index.html
```

---

## 🧹 Formatação e qualidade

* Padrão: **Google Java Format** via **Spotless**

```bash
# Aplicar formatação
./gradlew spotlessApply

# Verificar formatação (usado no CI)
./gradlew spotlessCheck
```

---

## 📦 Distribuição (binários)

Gere pacotes executáveis sem depender do Gradle instalado no alvo:

```bash
# Instala um diretório executável em build/install/RunnerSim
./gradlew installDist

# Gera um zip em build/distributions/RunnerSim.zip
./gradlew distZip
```

Para executar a distribuição local:

```bash
# Linux / macOS
./build/install/RunnerSim/bin/RunnerSim

# Windows
.\build\install\RunnerSim\bin\RunnerSim.bat
```

---

## 🗂 Estrutura do projeto

```
.
├─ build.gradle.kts
├─ settings.gradle.kts            # rootProject.name = "RunnerSim"
├─ src
│  ├─ main
│  │  ├─ java
│  │  │  └─ poo/trabalho/fun/
│  │  │     ├─ UsaSimulador.java # Main (console)
│  │  │     ├─ Simulador.java    # Regras + armazenamento (List/Map)
│  │  │     ├─ Leitor.java       # Entrada robusta (console)
│  │  │     ├─ Veiculo.java, Roda.java
│  │  │     └─ veiculos/
│  │  │        ├─ Bicicleta.java
│  │  │        ├─ VeiculoMotorizado.java
│  │  │        └─ motorizados/
│  │  │           ├─ CarroPasseio.java
│  │  │           ├─ Esportivo.java
│  │  │           └─ Motocicleta.java
│  │  └─ resources/              # (reservado p/ i18n, configs)
│  └─ test
│     └─ java/                   # Testes (JUnit 5)
└─ saves/                        # Arquivos gerados em runtime (gitignored)
```

---

## 🖱 Exemplo de sessão

```
MENU     Quantidade de Veiculos: 0
(1) Incluir veiculo
...
(15) Sair da aplicacao
Escolha uma opção: 1

INCLUIR VEICULO
Informe o tipo de veiculo (B, M, C, E): B
Veiculo incluído.

MENU     Quantidade de Veiculos: 1
...
Escolha uma opção: 13

Gravando arquivo
Salvo em: saves/simulador.dat
```

---

## ⚙️ Configurações úteis

* **Teclado no `run`**: o `build.gradle.kts` já pluga `System.in` no task `run`:

  ```kotlin
  tasks.named<JavaExec>("run") { standardInput = System.`in` }
  ```
* **Logs**: SLF4J + Logback já prontos para uso (adicione um `logback.xml` em `src/main/resources` se desejar).

---

## 📄 Licença

Este projeto está licenciado sob os termos da **MIT License** — veja o arquivo [`LICENSE`](./LICENSE).

[![CI](https://github.com/<owner>/<repo>/actions/workflows/ci.yml/badge.svg?branch=main)](https://github.com/<owner>/<repo>/actions/workflows/ci.yml)

---
