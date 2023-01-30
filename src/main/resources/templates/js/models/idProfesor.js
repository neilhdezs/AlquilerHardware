export class IdProfesor {
    constructor(id, nombre, apellidos) {
        this._id = id;
        this._nombre = nombre;
        this._apellidos = apellidos;
    }


    get id() {
        return this._id;
    }

    set id(value) {
        this._id = value;
    }

    get nombre() {
        return this._nombre;
    }

    set nombre(value) {
        this._nombre = value;
    }

    get apellidos() {
        return this._apellidos;
    }

    set apellidos(value) {
        this._apellidos = value;
    }
}