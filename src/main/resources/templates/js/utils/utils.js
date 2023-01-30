
export function checkAula(aula)
{
    if (aula.numeroAula.toString().length === 1) {
        return aula.planta.toString() + "0" + aula.numeroAula.toString();
    }
    return aula.planta.toString() + aula.numeroAula.toString();
}

export function checkHours(date)
{
    if (date.getMinutes() < 10) {
        return date.getHours() + ":0" + date.getMinutes();
    }

    return date.getHours() + ":" + date.getMinutes();

}