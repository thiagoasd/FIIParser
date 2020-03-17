package parser;

import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLParser {

	String url;
	String urlCotacoes = "https://www.clubefii.com.br/fundo_imobiliario_lista";

	public HTMLParser(String url) {
		this.url = url;

	}

	public void getFundos() {
		List<Fundo> fundos = new ArrayList<Fundo>();

		try {
			Document doc = Jsoup.connect(url).get();
			Elements items = doc.select("#items-wrapper > div.item");

			NumberFormat nf = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
			for (Element item : items) {

				Element ele = item.child(0).child(0);
				String ticket = ele.text();
				ele = item.child(0).child(1);
				String nome = ele.text();
				String link = item.child(0).attr("href");

				Document fundoDoc = Jsoup.connect(link).get();
				Elements eleFundo = fundoDoc.select("#informations--indexes > div > span");
				String dividendoText = eleFundo.get(0).ownText();
				eleFundo = fundoDoc.select("#quotations--infos-wrapper > div > span");
				String cotacaoText = eleFundo.get(1).text();

				System.out.println(item);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Cotacao> getFundos2() {
		List<Cotacao> cotacoes = new ArrayList<Cotacao>();

		try {
			Document doc = Jsoup.connect("https://www.fundsexplorer.com.br/ranking").get();
			Elements items = doc.select("table#table-ranking > tbody > tr");
			NumberFormat nf = NumberFormat.getNumberInstance(new Locale("pt", "BR"));

			for (Element linha : items) {
				try {
					String nome = linha.child(0).text();

					String tmp = linha.child(2).text().substring(3);
					float valor;

					valor = nf.parse(tmp).floatValue();

					tmp = linha.child(4).text().substring(3);
					float dividendo = nf.parse(tmp).floatValue();

					cotacoes.add(new Cotacao(nome, valor, dividendo));
				} catch (ParseException e) {
					System.out.println(linha.child(0).text());
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cotacoes;

	}

	public List<Cotacao> getCotacoes() {
		List<Cotacao> cotacoes = new ArrayList<Cotacao>();
		NumberFormat nf = NumberFormat.getNumberInstance(new Locale("pt", "BR"));

		try {
			Document doc = Jsoup.connect("https://www.fundsexplorer.com.br/ranking").get();
			Elements items = doc.select("table#table-ranking > tbody > tr");

			for (Element linha : items) {
				String nome = linha.child(0).text();
				String tmp = linha.child(2).text().substring(3);
				float valor = nf.parse(tmp).floatValue();
				// cotacoes.add(new Cotacao(nome, valor));

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cotacoes;

	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
