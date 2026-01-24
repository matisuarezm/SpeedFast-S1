# 📘 Proyecto: SpeedFast - Semana 3

## 📝 Descripción general del sistema

Se solicita crear un sistema para la empresa SpeedFast, la cual es una empresa de reparto a domicilio que ofrece tres tipos de servicios. Entre ellos la entrega de "Comida", que corresponde a compras en restaurantes, además la entrega de "Encomiendas", correspondiente a todo tipo de documentos o paquetes y finalmente "Compras Express", que se encarga del reparto de compras en supermercado y farmacia.
Para el desarrollo se utiliza JAVA como lenguaje de programación y se implementa una jerarquía de clases aplicando abstracción, polimorfismo, sobrecarga y sobrescritura de métodos.

En esta nueva entrega de la semana 3, Creamos interfaces para aplicar reglas de negocio particulares.

---
## 🧱 Estructura general del proyecto

```
📦 SpeedFast/
┣ 📂 .idea/
┣ 📂 img/
┣ 📂 src/main/java/cl/speedFast
┃ ┣ 📂 Interfaces/
┃ ┃ ┣ 📊 Cancelable.java		     #Interfaz para cancelar pedidos.
┃ ┃ ┣ 📊 Despachable.java		     #Interfaz para despachar y registrar evento
┃ ┃ ┣ 📊 Rastreable.java		     #Interfaz como lista que guarda los eventos realizados
┃ ┣ 📂 model/
┃ ┃ ┣ 📊 Pedido.java		             #Clase abstracta base con información general para herencia y método abstracto.
┃ ┃ ┣ 📊 PedidoComida.java		     #Clase heredada de Pedido e implementacion de interfaces.
┃ ┃ ┣ 📊 PedidoEncomienda.java		     #Clase heredada de Pedido e implementacion de interfaces.
┃ ┃ ┣ 📊 PedidoExpress.java		     #Clase heredada de Pedido e implementacion de interfaces.
┃ ┣ 📂 ui/
┃ ┃ ┣ 📊 Main.java		             #Punto de entrada y ejecución principal (Main.java).
┃ 📜 README.md
┗ 📜 SpeedFast.iml

```
---
## 🧩 Requisitos

Para trabajar correctamente con los recursos de este repositorio, asegúrate de tener instalado lo siguiente:

- ☕ **Java JDK 21 o superior**  
  - [Descargar Java](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)

- 💻 **IDE recomendado: IntelliJ IDEA Community Edition**  
  - [Descargar IntelliJ IDEA (Community Edition)](https://www.jetbrains.com/idea/download/)  

- 🧰 **Git instalado para clonar y versionar el repositorio**  
  - [Descargar Git](https://git-scm.com/downloads)

- 🌐 **Cuenta de GitHub activa** (obligatoria)  
  - [Crear cuenta en GitHub](https://github.com/signup)  
   > Tu cuenta te servirá para clonar repositorios, subir avances, y entregar evaluaciones a través de GitHub. 

---
## ⚙️ Instrucción de Ejecución

### Instrucciones para clonar y ejecutar el proyecto en IDE

- clonar el repositorio de github
```bash
git clone https://github.com/matisuarezm/SpeedFast.git
```
- Abre el proyecto en IntelliJ IDEA.
- Abre la clase `Main.java` del paquete `ui`
- Puedes ejecutar el proyecto.

	> Nota: Al ejecutar la clase Main.java se mostrarán los resultados por la consola, tal como se ve en la imagen.

    ![Salida por Consola](img/imagen.png)

---

## 👤 Autor del proyecto
- **Nombre completo:** Matias Suarez M.
- **Sección:** 003A
- **Carrera:** Analista Programador Computacional
- **Sede:** Carrera 100% Online


