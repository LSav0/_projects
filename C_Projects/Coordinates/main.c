#include <stdio.h>
#include <stdlib.h>
#include <math.h>

struct Koordinaatit
{

    float x, y;

};


float KetjunPituus(struct Koordinaatit Piste1, struct Koordinaatit Piste2, struct Koordinaatit Piste3,struct Koordinaatit Piste4,struct Koordinaatit Piste5)
{
    float etaisyys1, etaisyys2, etaisyys3, etaisyys4;
    float koketaisyys;

    etaisyys1= sqrt((Piste1.x - Piste2.x) * (Piste1.x - Piste2.x) + (Piste1.y-Piste2.y) *(Piste1.y-Piste2.y));
    etaisyys2= sqrt((Piste2.x - Piste3.x) * (Piste2.x - Piste3.x) + (Piste2.y-Piste3.y) *(Piste2.y-Piste3.y));
    etaisyys3= sqrt((Piste3.x - Piste4.x) * (Piste3.x - Piste4.x) + (Piste3.y-Piste4.y) *(Piste3.y-Piste4.y));
    etaisyys4= sqrt((Piste4.x - Piste5.x) * (Piste4.x - Piste5.x) + (Piste4.y-Piste5.y) *(Piste4.y-Piste5.y));

    koketaisyys = etaisyys1 + etaisyys2 + etaisyys3 + etaisyys4;

    return koketaisyys;
}
float LinnunTie(struct Koordinaatit Piste1, struct Koordinaatit Piste2, struct Koordinaatit Piste4, struct Koordinaatit Piste5)
{
    float etaisyys5;

    etaisyys5 = sqrt((Piste1.x - Piste5.x) * (Piste1.x - Piste5.x) + (Piste1.y-Piste5.y) *(Piste1.y-Piste5.y));

    return etaisyys5;
}
int main()
{
    struct Koordinaatit Piste1, Piste2, Piste3, Piste4, Piste5;

    printf("Anna koordinaatit a: ");
    scanf("%f %f", &Piste1.x, &Piste1.y);

    printf("Anna koordinaatit b: ");
    scanf("%f %f", &Piste2.x, &Piste2.y);

    printf("Anna koordinaatit c: ");
    scanf("%f %f", &Piste3.x, &Piste3.y);

    printf("Anna koordinaatit d: ");
    scanf("%f %f", &Piste4.x, &Piste4.y);

    printf("Anna koordinaatit e: ");
    scanf("%f %f", &Piste5.x, &Piste5.y);

    printf("Etaisyys mutkitellen on %.3f\n", KetjunPituus(Piste1, Piste2, Piste3, Piste4, Piste5));
    printf("Alku ja loppupisteiden valinen etaisyys on %.3f\n", LinnunTie(Piste1, Piste2, Piste4, Piste5));


    return 0;
}
