export class IdCarritoTablets {
    constructor(id, numeroTablets, planta) {
        this._id = id;
        this._numeroTablets = numeroTablets;
        this._planta = planta;
    }


    get id() {
        return this._id;
    }

    set id(value) {
        this._id = value;
    }

    get numeroTablets() {
        return this._numeroTablets;
    }

    set numeroTablets(value) {
        this._numeroTablets = value;
    }

    get planta() {
        return this._planta;
    }

    set planta(value) {
        this._planta = value;
    }
}