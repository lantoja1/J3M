##J3M
Semestrální projekt pro A4M33VIA FEL ČVUT.

##Motivace
Chceme udělat mobilní aplikaci pro jednoduchou správu objednávek e-shopu.
Aplikace je určená pro správce malého e-shopu, né pro zákazníky.
Aplikace má ukazovat informace o aktuálních objednávkách (i offline), s možností změny stavu objednávky (například zadat že objednávka byla odeslána na poště). Dále bude upozorňovat na nové objednávky.

Hlavní správa celého e-shopu umožňuje více možností práce s objednávkami, proto je potřeba zařídit synchronizaci mezi mobilem a serverem.

##Serverová část
Serverová část funguje v jakémkoliv servletovém kontejneru, např. Apache Tomcat. Obsahuje REST servlet s veřejným API
na adrese /rest/*. API pracuje ve formátech XML a JSON, formát závisí na content type requestu.

##API
	* /rest/neworders [GET] - vrací sezname nových objednávek (stav *__NEW__*)
	* /rest/order/{id} [GET] - vrací detail objednávky s ID = {id}
	* /rest/order [PUT] - update detailu objednávky (stačí ID a stav objednávky)
	* /rest/addorders [PUT] - přidává seznam nových objednávek (stav *__NEW__*)