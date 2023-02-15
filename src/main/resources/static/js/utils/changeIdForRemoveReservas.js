const selectionReserva = document.getElementById("selectionReserva");

selectionReserva.addEventListener("click", changeId);

function changeId() {

    const id = document.getElementById("id");

    if (selectionReserva.value === "aula") {
        id.innerHTML = "Id del Aula: ";
    }
    else if (selectionReserva.value === "pc") {
        id.innerHTML = "Id del carrito de PCs: ";
    }
    else
    {
        id.innerHTML = "Id del carrito de Tablets: ";
    }
}