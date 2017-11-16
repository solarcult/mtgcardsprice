package org.shil.mtg;

public class CardsList {
	
	public static String[] getCardhoarderCardsList(){
		
		String[] cardslist = {

				//SOI
				"https://www.cardhoarder.com/cards/59842",
				"https://www.cardhoarder.com/cards/59920",
				
				//KLD
				"https://www.cardhoarder.com/cards/61855",
				"https://www.cardhoarder.com/cards/61849",
				"https://www.cardhoarder.com/cards/62019",
				"https://www.cardhoarder.com/cards/61589",
				"https://www.cardhoarder.com/cards/61575",
				"https://www.cardhoarder.com/cards/61963",
				"https://www.cardhoarder.com/cards/62029",
				"https://www.cardhoarder.com/cards/62017",
				"https://www.cardhoarder.com/cards/61775",
				"https://www.cardhoarder.com/cards/61879",
				"https://www.cardhoarder.com/cards/62085",
				"https://www.cardhoarder.com/cards/61857",
				"https://www.cardhoarder.com/cards/62037",
				"https://www.cardhoarder.com/cards/62021",
				"https://www.cardhoarder.com/cards/61957",
				
				//AER
				"https://www.cardhoarder.com/cards/62565",
				"https://www.cardhoarder.com/cards/62895",
				"https://www.cardhoarder.com/cards/62557",
				"https://www.cardhoarder.com/cards/62829",
				"https://www.cardhoarder.com/cards/62745",
				"https://www.cardhoarder.com/cards/62803",
				
				//AKH
				"https://www.cardhoarder.com/cards/63630",
			};
		
		return cardslist;
	}
	
	public static String[] getMtggoldfishCardsList(){
		
		String[] cardslist = {
				
				/*
				//SOI
				"https://www.mtggoldfish.com/price/Shadows+over+Innistrad/Fortified+Village#online",
				"https://www.mtggoldfish.com/price/Shadows+over+Innistrad/Choked+Estuary#online",
				"https://www.mtggoldfish.com/price/Shadows+over+Innistrad/Foreboding+Ruins#online",
				"https://www.mtggoldfish.com/price/Shadows+over+Innistrad/Sigarda+Herons+Grace#online",
				"https://www.mtggoldfish.com/price/Shadows+over+Innistrad/Arlinn+Kord#online",
				"https://www.mtggoldfish.com/price/Shadows+over+Innistrad/Mindwrack+Demon#online",
				"https://www.mtggoldfish.com/price/Shadows+over+Innistrad/Odric+Lunarch+Marshal#online",
				
				//EM
				"https://www.mtggoldfish.com/price/Eldritch+Moon/Voldaren+Pariah#online",
				"https://www.mtggoldfish.com/price/Eldritch+Moon/Thalia+Heretic+Cathar#online",
				left from 2017Sep25
				*/

				//KLD
				"https://www.mtggoldfish.com/price/Kaladesh/Inspiring+Vantage#online",
				"https://www.mtggoldfish.com/price/Kaladesh/Nissa+Vital+Force#online",
				"https://www.mtggoldfish.com/price/Kaladesh/Dovin+Baan#online",
				"https://www.mtggoldfish.com/price/Kaladesh/Depala+Pilot+Exemplar#online",
				"https://www.mtggoldfish.com/price/Kaladesh/Rashmi+Eternities+Crafter#online",
				"https://www.mtggoldfish.com/price/Kaladesh/Toolcraft+Exemplar#online",
				"https://www.mtggoldfish.com/price/Kaladesh/Electrostatic+Pummeler#online",
				"https://www.mtggoldfish.com/price/Kaladesh/Inventors+Fair#online",
				"https://www.mtggoldfish.com/price/Kaladesh/Kambal+Consul+of+Allocation#online",
				"https://www.mtggoldfish.com/price/Kaladesh/Oviya+Pashiri+Sage+Lifecrafter#online",
				"https://www.mtggoldfish.com/price/Kaladesh/Gonti+Lord+of+Luxury#online",
				"https://www.mtggoldfish.com/price/Kaladesh/Pia+Nalaar#online",
				"https://www.mtggoldfish.com/price/Kaladesh/Paradoxical+Outcome#online",
				"https://www.mtggoldfish.com/price/Kaladesh/Cataclysmic+Gearhulk#online",
				
				//AER
				"https://www.mtggoldfish.com/price/Aether+Revolt/Hope+of+Ghirapur#online",
				"https://www.mtggoldfish.com/price/Aether+Revolt/Tezzeret+the+Schemer#online",
				"https://www.mtggoldfish.com/price/Aether+Revolt/Oath+of+Ajani#online",
				"https://www.mtggoldfish.com/price/Aether+Revolt/Kari+Zev+Skyship+Raider#online",
				"https://www.mtggoldfish.com/price/Aether+Revolt/Quicksmith+Rebel#online",
				"https://www.mtggoldfish.com/price/Aether+Revolt/Pias+Revolution#online",
				"https://www.mtggoldfish.com/price/Aether+Revolt/Aid+from+the+Cowl#online",
				"https://www.mtggoldfish.com/price/Amonkhet/Bounty+of+the+Luxa#online",
				
				//AKH
				"https://www.mtggoldfish.com/price/Amonkhet/Scattered+Groves",
				"https://www.mtggoldfish.com/price/Amonkhet/Cascading+Cataracts#online",
				"https://www.mtggoldfish.com/price/Amonkhet/Canyon+Slough#online",
				"https://www.mtggoldfish.com/price/Amonkhet/Neheb+the+Worthy#online",
				"https://www.mtggoldfish.com/price/Hour+of+Devastation/Mirage+Mirror#online",
				"https://www.mtggoldfish.com/price/Hour+of+Devastation/Samut+the+Tested#online",
				"https://www.mtggoldfish.com/price/Hour+of+Devastation/Torment+of+Hailfire",
				"https://www.mtggoldfish.com/price/Amonkhet/Kefnet+the+Mindful#online",
				"https://www.mtggoldfish.com/price/Amonkhet/Combat+Celebrant#online",
				"https://www.mtggoldfish.com/price/Amonkhet/Rhonas+the+Indomitable#online",
				"https://www.mtggoldfish.com/price/Amonkhet/Bounty+of+the+Luxa#online",
				"https://www.mtggoldfish.com/price/Ixalan/Sword-Point+Diplomacy#online",
				"https://www.mtggoldfish.com/price/Ixalan/Ripjaw+Raptor#online",
				"https://www.mtggoldfish.com/price/Ixalan/Dreamcaller+Siren#online",
				"https://www.mtggoldfish.com/price/Ixalan/Kopala+Warden+of+Waves#online",
				"https://www.mtggoldfish.com/price/Ixalan/Revel+in+Riches#online"
		};
		
		return cardslist;
	}

}
