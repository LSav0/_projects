#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void Valikko();
void Tarkistasaldo (int *saldo);
int RahanNosto (int *saldo);
int RahanTalletus(int *saldo);
void poistu();


int main(void)
{

    int saldo = 2000;

    while(1)
    {

        int valinta;

        Valikko();

        scanf("%d", &valinta);
        switch(valinta)
        {
        case 1:
            Tarkistasaldo (&saldo);
            break;

        case 2:
            RahanNosto (&saldo);
            break;

        case 3:
            RahanTalletus (&saldo);
            break;

        case 4:
            poistu();
            return 0;

           default:
                printf("Virhe! Valitse uudelleen\n");
                break;

        }
    }
    return 0;

}

void Valikko()
{

    printf("\n*****Valikko*****\n");
    printf("1.Saldo\n");
    printf("2.Nosto\n");
    printf("3.Talletus\n");
    printf("4.Poistu\n");

}
void Tarkistasaldo (int *saldo)
{

    printf("\nSaldosi on %d euroa", *saldo);

}
int RahanNosto (int *saldo)
{

    int nosto;
    int seteli50 = 0;
    int seteli20 = 0;
    int uusiSaldo;

    printf("\nSaldosi on %d euroa\n", saldo);
    printf("\nPaljonko haluat nostaa? > ");
    scanf("%d", &nosto);

    if (nosto < 20 || nosto % 10 != 0
        || nosto == 30 || nosto > 2000)
    {
        printf("Virheellinen nostosumma\n");
        return 0;
    }

    printf("\nNostetaan %d euroa\n", nosto);
    *saldo = uusiSaldo;
    printf("\nUusi saldosi on %d euroa\n", uusiSaldo);

    while (nosto > 0)
    {

        if(nosto % 50 == 0)
        {
            seteli50++;
            nosto -= 50;
        }

        else
        {
            seteli20++;
            nosto -= 20;
        }
    }
    printf("Sait %d kpl 20 euron seteleita\n", seteli20);
    printf("Sait %d kpl 50 euron seteleita\n", seteli50);

    return 1;
}

int RahanTalletus (int *saldo)
{

    int talletus;

    printf("\nPaljonko haluat tallettaa? > ");
    scanf("%d", &talletus);
    *saldo += talletus;

    printf("\nUusi saldosi on %d euroa", *saldo);
    return 1;
}

void poistu()
{
    printf("\nKiitos kun kaytit automaattia");
    printf("\nTervetuloa uudelleen!");
}
