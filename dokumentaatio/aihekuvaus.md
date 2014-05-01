Aihe: Avaruusteemainen vuoropohjainen laivanupotuspeli. Pelaaja ja tekoälyvastustaja ensin asettavat laivastonsa pelilaudalle, ja sitten yrittävät vuorollaan "upottaa" toisen laivat. 

Käyttäjät: pelaaja tietokoneella 

Toiminnot: 

* laivojen asettaminen omalle laudalle
* ihmispelaajan pelivuoron pelaaminen - ampuminen vastustajan laudalle
* uuden pelin aloitus - New Game nappi


Ohjelman rakenne

Ohjelman ydin on Game-luokka, joka sisältää pelin päämetodit, kuten pelin aloitus ja pelivuoroluuppi. Peliä kontrolloidaan graafisella käyttöliittymällä, jossa on pääluokan UI lisäksi kuuntelijoita ja pelilautojen graafiset piirtoluokat.

Pelissä on kaksi pelaaja-luokkaa, Human ja AI, joiden metodeilla ne "ampuvat" yrittäessään upottaa toistensa laivoja. Molemmilla on oma pelilauta, HumanBoard ja AIBoard. Nämä pelilaudat perivät Board-yliluokan ja niille asetetaan Ship-luokan ilmentymiä jotka talletetaan HashMapiin. Pelilaudat kuvataan taulukoina, joiden solujen sisältö kertoo yksiselitteisesti pelitilanteen. 

