export class IdCarritoPcs {
    constructor(id, numeroPcs, planta, sistemaOperativo) {
        this._id = id;
        this._numeroPcs = numeroPcs;
        this._planta = planta;
        this._sistemaOperativo = sistemaOperativo;
    }


    get id() {
        return this._id;
    }

    set id(value) {
        this._id = value;
    }

    get numeroPcs() {
        return this._numeroPcs;
    }

    set numeroPcs(value) {
        this._numeroPcs = value;
    }

    get planta() {
        return this._planta;
    }

    set planta(value) {
        this._planta = value;
    }

    get sistemaOperativo() {
        return this._sistemaOperativo;
    }

    set sistemaOperativo(value) {
        this._sistemaOperativo = value;
    }
}