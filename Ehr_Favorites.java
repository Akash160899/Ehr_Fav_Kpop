package ehr_favorite;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.BaseClass.Base_Class;
import com.data.ConfigManager;

import com.pageObjectMan.PageObjMan;

public class Ehr_Favorites extends Base_Class {

	public static WebDriver driver;
	static PageObjMan pom;
	static JavascriptExecutor j;
	WebDriverWait ww;
	String kpid;

	@BeforeClass
	private void l() throws InterruptedException, IOException {

		driver = browserLaunch("chrome");
		pom = new PageObjMan(driver);
		j = (JavascriptExecutor) driver;
		ww = new WebDriverWait(driver, 60);
		String ur = ConfigManager.getconfigManager().getInstanceConfigReader().getUrl();

		while (true) {
			if (ur.equals("https://localhost:8443/")) {

				driver.get(ConfigManager.getconfigManager().getInstanceConfigReader().getUrl());
				sleep(3000);
				driver.findElement(By.id("details-button")).click();
				sleep(3000);

				driver.findElement(By.id("proceed-link")).click();
				sleep(4000);
				implicitWait(60, TimeUnit.SECONDS);

				break;
			} else if (ur.equals("https://www.75health.com/login.jsp")) {
				driver.get("https://www.75health.com/login.jsp");

				break;
			}

		}

		click(pom.getInstanceLoginPage().sigIn);
		sleep(2000);
		sendkeys(pom.getInstanceLoginPage().email,
				ConfigManager.getconfigManager().getInstanceConfigReader().getEmail());
		sendkeys(pom.getInstanceLoginPage().pass, ConfigManager.getconfigManager().getInstanceConfigReader().getpass());
		click(pom.getInstanceLoginPage().login);

		ww.until(ExpectedConditions.urlToBe("https://localhost:8443/health/#home"));
		// https://localhost:8443/health/#home
		// https://www.75health.com/health/#home

	}

	@Test(priority = 0)
	private void site() throws InterruptedException {
		driver.navigate().to("https://localhost:8443/health/#list_ehr");
		// https://localhost:8443/health/#list_ehr

		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		implicitWait(60, TimeUnit.SECONDS);
		WebElement remv = driver.findElement(By.xpath("(//div[@id='ehr-search']/div[2]//following::input[1])[1]"));
		visbility(driver, remv, 60);

		javascriptclick(remv);
		sleep(2000);
		List<WebElement> wwe = driver
				.findElements(By.xpath("//div[@id='vvid']//following::ul[2]/li/a/table/tbody/tr/td[2]"));
		for (WebElement web : wwe) {

			if (web.getText().trim().equals("3088-514")) {

				visbility(driver, web, 60);
				clickble(driver, web, 60);

				break;
			}

		}
		sleep(2000);

		WebElement r7 = driver.findElement(By.id("newMedicalRecordButton"));
		visbility(driver, r7, 60);
		javascriptclick(r7);

	}

	@Test(priority = 1, invocationCount = 4)
	private void visitReason() throws InterruptedException {

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement fvvis = driver.findElement(By.xpath("//div[contains(@title,'Show my favorite Visit ')]"));
				actions("move to element", fvvis);
				visbility(driver, fvvis, 60);
				javascriptclick(fvvis);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement addfv = driver.findElement(
						By.xpath("//div[@id='Visit_ReasonFavKpop2']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]"));
				visbility(driver, addfv, 60);
				javascriptclick(addfv);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement fv = driver.findElement(By.xpath("//div[@id='Visit_ReasonKpop2']/div[1]//following::select[1]"));
		dropDown("index", fv, "1");
		WebElement fv2 = driver.findElement(By.xpath("//div[@id='Visit_ReasonPellVal']/div[2]"));
		visbility(driver, fv2, 60);
		sendkeys(fv2, "favorite visit reason");

		WebElement fv3 = driver.findElement(By.xpath("//div[@id='Visit_ReasonPell']//following::button[2]"));
		visbility(driver, fv3, 60);
		javascriptclick(fv3);

		for (int i = 1; i <= 5; i++) {

			try {

				WebElement fv4 = driver.findElement(By.xpath("(//div[text()='favorite visit reason'])[1]"));
				visbility(driver, fv4, 60);
				javascriptclick(fv4);

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement fv5 = driver.findElement(By.xpath("//div[@id='Visit_ReasonKpop2']/div[1]//following::select[1]"));
		dropDown("index", fv5, "2");

		WebElement fv6 = driver.findElement(By.xpath("//div[@id='Visit_ReasonPellVal']/div[2]"));
		visbility(driver, fv6, 60);
		clear(fv6);
		sendkeys(fv6, "Vist fav");

		WebElement fv7 = driver.findElement(By.xpath("//div[@id='Visit_ReasonPell']//following::button[2]"));
		visbility(driver, fv7, 60);
		javascriptclick(fv7);

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement fv8 = driver.findElement(By.xpath("(//span[@title='Add this visit reason'])[1]"));
				visbility(driver, fv8, 60);
				javascriptclick(fv8);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement fv9 = driver
						.findElement(By.xpath("//div[@id='Visit_ReasonFavKpop2']/div[1]/div[1]//following::span[1]"));
				visbility(driver, fv9, 60);
				javascriptclick(fv9);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(1500);

	}

	@Test(priority = 2, invocationCount = 4)
	private void Vaccine() throws InterruptedException {

		for (int i = 1; i <= 5; i++) {

			try {
				WebElement vc1 = driver
						.findElement(By.xpath("//div[contains(@title,'Show my favorite Vaccine list ')]"));
				actions("move to element", vc1);
				visbility(driver, vc1, 60);
				javascriptclick(vc1);

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement vc2 = driver
				.findElement(By.xpath("//div[@id='VaccineFavKpop2']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]"));
		visbility(driver, vc2, 60);
		javascriptclick(vc2);

		WebElement vc3 = driver.findElement(By.xpath("//div[@id='VaccineKpop2']/div[1]/div[1]//following::input[1]"));
		visbility(driver, vc3, 60);
		sendkeys(vc3, "vacc");
		List<WebElement> vc4;
		while (true) {

			vc4 = driver.findElements(By.xpath(
					//// div[@id='VaccineKpop2']/div[1]/div[1]//following::input[2]//following::button[1]//following::ul[2]/li/a/span[2]

					"//div[@id='VaccineKpop2']/div[1]/div[1]//following::input[2]//following::button[1]//following::ul[1]/li/a/span[2]"));

			if (vc4.size() >= 5) {
				System.out.println(vc4.size());
				break;
			}
		}

		for (WebElement web : vc4) {
			System.out.println(web.getText());

			if (web.getText().trim().equals("vaccinia (smallpox) diluted")) {
				web.click();
				break;
			}

		}

		WebElement vc5 = driver.findElement(By.xpath("//div[@id='VaccineKpop2']/div[1]/div[1]//following::input[2]"));

		visbility(driver, vc5, 60);
		sendkeys(vc5, "vacine favorite");

		WebElement vc6 = driver.findElement(By.xpath("//div[@id='VaccineKpop2']/div[1]/div[1]//following::button[2]"));
		visbility(driver, vc6, 60);
		javascriptclick(vc6);
		sleep(2000);

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement vc7 = driver
						.findElement(By.xpath("(//span[@title='Add this vaccine'])[1]//following::div[1]/div[2]"));
				visbility(driver, vc7, 60);
				javascriptclick(vc7);

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement vc8 = driver.findElement(By.xpath("//input[@id='vaccine-cvx']//following::span[3]"));
		javascriptclick(vc8);

		WebElement vc9 = driver.findElement(By.xpath("//div[@id='VaccineKpop2']/div[1]/div[1]//following::input[1]"));
		visbility(driver, vc9, 60);
		sendkeys(vc9, "vacc");
		List<WebElement> vc10;
		while (true) {

			vc10 = driver.findElements(By.xpath(
					"//div[@id='VaccineKpop2']/div[1]/div[1]//following::input[2]//following::button[1]//following::ul[1]/li/a/span[2]"));
			if (vc10.size() >= 5) {
				break;
			}
		}

		for (WebElement we : vc10) {

			if (we.getText().trim().equals("vaccinia immune globulin")) {

				visbility(driver, we, 60);
				javascriptclick(we);
				break;
			}

		}

		WebElement vc11 = driver.findElement(By.xpath("//div[@id='VaccineKpop2']/div[1]/div[1]//following::input[2]"));
		visbility(driver, vc11, 60);
		clear(vc11);
		sendkeys(vc11, "vacine module");

		WebElement vc12 = driver.findElement(By.xpath("//div[@id='VaccineKpop2']/div[1]/div[1]//following::button[2]"));
		visbility(driver, vc12, 60);
		javascriptclick(vc12);

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement vc13 = driver.findElement(By.xpath("(//span[@title='Add this vaccine'])[1]"));
				visbility(driver, vc13, 60);
				javascriptclick(vc13);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		sleep(1500);
		WebElement vc14 = driver
				.findElement(By.xpath("//div[@id='VaccineFavKpop2']/div[1]/div[1]//following::span[1]"));
		visbility(driver, vc14, 60);
		javascriptclick(vc14);

	}

	@Test(priority = 4, invocationCount = 4)
	private void symptoms() throws InterruptedException {

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement sypmtomfavicon = driver
						.findElement(By.xpath("//div[contains(@title,'Show my favorite Symptoms list fo')]"));
				actions("move to element", sypmtomfavicon);
				visbility(driver, sypmtomfavicon, 60);
				javascriptclick(sypmtomfavicon);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement addnewsympfav = driver.findElement(
						By.xpath("//div[@id='SymptomsFavKpop2']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]"));
				visbility(driver, addnewsympfav, 60);
				javascriptclick(addnewsympfav);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement sympicdbox = driver
				.findElement(By.xpath("//div[@id='SymptomsKpop2']/div[2]/div[1]/div[2]/div[2]/input"));
		visbility(driver, sympicdbox, 60);
		sendkeys(sympicdbox, "test");
		List<WebElement> symptomsdrop;
		while (true) {
			try {
				symptomsdrop = driver.findElements(By
						.xpath("//div[@id='addfav-div']/div/div/div[4]//following::div[1]//following::ul[1]/li/a/div"));
				if (symptomsdrop.size() > 5) {
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		for (WebElement web : symptomsdrop) {
			if (web.getText().trim().equals("R76.1: Abnormal reaction to tuberculin test")) {
				visbility(driver, web, 60);
				javascriptclick(web);
				break;
			}

		}
		WebElement symptsdis = driver.findElement(By.xpath("//div[@id='Symptom-div']/div[2]/input"));
		visbility(driver, symptsdis, 60);
		sendkeys(symptsdis, "symptoms favorite");
		WebElement savesymptfav = driver.findElement(By.xpath("//div[@id='SymptomsKpop2']/div[2]/div[2]/button[2]"));
		visbility(driver, savesymptfav, 60);
		javascriptclick(savesymptfav);
		sleep(2000);
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement editsympfav = driver
						.findElement(By.xpath("(//div[text()='R76.1: Abnormal reaction to tuberculin test'])[1]"));
				visbility(driver, editsympfav, 60);
				javascriptclick(editsympfav);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement crossicon = driver.findElement(By.xpath("//span[text()='R76.1']//following::span[1]"));
		visbility(driver, crossicon, 60);
		javascriptclick(crossicon);

		WebElement sympicdbox2 = driver
				.findElement(By.xpath("//div[@id='SymptomsKpop2']/div[2]/div[1]/div[2]/div[2]/input"));
		visbility(driver, sympicdbox2, 60);
		sendkeys(sympicdbox2, "test");
		List<WebElement> symptomsdrop2;

		while (true) {
			try {

				symptomsdrop2 = driver.findElements(By
						.xpath("//div[@id='addfav-div']/div/div/div[4]//following::div[1]//following::ul[1]/li/a/div"));
				if (symptomsdrop2.size() > 5) {
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		for (WebElement web : symptomsdrop2) {
			if (web.getText().trim().equals("R85.81: Anal high risk human papillomavirus (HPV) DNA test positive")) {
				visbility(driver, web, 60);
				javascriptclick(web);
				break;
			}

		}

		WebElement symptsdis2 = driver.findElement(By.xpath("//div[@id='Symptom-div']/div[2]/input"));
		visbility(driver, symptsdis2, 60);
		clear(symptsdis2);
		sendkeys(symptsdis2, "symptoms favorite kpop2");

		WebElement savesymptfav2 = driver.findElement(By.xpath("//div[@id='SymptomsKpop2']/div[2]/div[2]/button[2]"));
		visbility(driver, savesymptfav2, 60);
		javascriptclick(savesymptfav2);

		WebElement addsymptolist = driver.findElement(By.xpath("(//span[contains(@title,'Add this symptom')])[1]"));
		visbility(driver, addsymptolist, 60);
		javascriptclick(addsymptolist);

		WebElement closefavkpopwin = driver
				.findElement(By.xpath("//div[@id='SymptomsFavKpop2']/div[1]/div[1]//following::span[1]"));
		visbility(driver, closefavkpopwin, 60);
		javascriptclick(closefavkpopwin);

	}

	@Test(priority = 5, invocationCount = 3)
	private void procedure() throws InterruptedException {

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement prcdfav = driver
						.findElement(By.xpath("//div[contains(@title,'Show my favorite Procedure li')]"));
				actions("move to element", prcdfav);
				visbility(driver, prcdfav, 60);
				javascriptclick(prcdfav);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement prcdfaviconadd = driver.findElement(
						By.xpath("//div[@id='ProcedureFavKpop2']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]"));
				visbility(driver, prcdfaviconadd, 60);
				javascriptclick(prcdfaviconadd);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement selectprcddrop = driver.findElement(By.xpath("//div[@id='ProcedureKpop2']/div[2]/div[1]/select"));
		visbility(driver, selectprcddrop, 60);
		dropDown("index", selectprcddrop, "2");

		WebElement prcddis = driver
				.findElement(By.xpath("//div[@id='ProcedureKpop2']/div[2]/div[1]/select//following::input[1]"));
		visbility(driver, prcddis, 60);
		sendkeys(prcddis, "test");
		List<WebElement> prcddropdwn;

		while (true) {
			try {
				prcddropdwn = driver.findElements(By.xpath(
						"//div[@id='addfav-div']/div/div/div[4]//following::div[1]//following::ul[2]/li/a/div/small/em"));
				if (prcddropdwn.size() > 5) {
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		for (WebElement web : prcddropdwn) {

			if (web.getText().trim().equals("SNOMED : 134287002")) {
				// System.out.println("procedure met..");
				visbility(driver, web, 60);
				javascriptclick(web);
				break;

			}

		}
		WebElement prcddisbox = driver
				.findElement(By.xpath("//div[@id='ProcedureKpop2']/div[2]/div[1]/select//following::input[2]"));
		visbility(driver, prcddisbox, 60);
		sendkeys(prcddisbox, "procedure favorite");

		WebElement prcdsavefav = driver.findElement(By.xpath("//div[@id='ProcedureKpop2']/div[2]/div[2]/div/button"));
		visbility(driver, prcdsavefav, 60);
		javascriptclick(prcdsavefav);

		List<WebElement> svcs = driver
				.findElements(By.xpath("//div[@id='ProcedureKpop2']/div[2]/div[2]/div/button//following::ul[1]/li/a"));
		for (WebElement web : svcs) {
			if (web.getText().trim().equals("Save")) {
				visbility(driver, web, 60);
				javascriptclick(web);
				break;
			}

		}
		sleep(2000);
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement prcdfvlist = driver.findElement(
						By.xpath("(//div[text()='134287002: Cytomegalovirus antigen test (procedure)'])[1]"));
				visbility(driver, prcdfvlist, 60);
				javascriptclick(prcdfvlist);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement crossiconprcd = driver.findElement(By.xpath("//span[text()='134287002']//following::span[1]"));
		visbility(driver, crossiconprcd, 60);
		javascriptclick(crossiconprcd);

		WebElement prcddis2 = driver
				.findElement(By.xpath("//div[@id='ProcedureKpop2']/div[2]/div[1]/select//following::input[1]"));
		visbility(driver, prcddis2, 60);

		sendkeys(prcddis2, "test");
		List<WebElement> prcddropdwn2;
		while (true) {
			try {
				prcddropdwn2 = driver.findElements(By.xpath(
						"//div[@id='addfav-div']/div/div/div[4]//following::div[1]//following::ul[2]/li/a/div/b"));
				if (prcddropdwn2.size() > 5) {
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		for (WebElement web : prcddropdwn2) {

			if (web.getText().trim().equals("Platelet adhesiveness test (procedure)")) {

				visbility(driver, web, 60);
				javascriptclick(web);
				break;

			}

		}

		WebElement prcddisbox2 = driver
				.findElement(By.xpath("//div[@id='ProcedureKpop2']/div[2]/div[1]/select//following::input[2]"));
		visbility(driver, prcddisbox2, 60);
		clear(prcddisbox2);
		sendkeys(prcddisbox2, "procedure kpop2 favorite");

		WebElement prcdsavefav2 = driver.findElement(By.xpath("//div[@id='ProcedureKpop2']/div[2]/div[2]/div/button"));
		visbility(driver, prcdsavefav2, 60);
		javascriptclick(prcdsavefav2);

		List<WebElement> svcs1 = driver
				.findElements(By.xpath("//div[@id='ProcedureKpop2']/div[2]/div[2]/div/button//following::ul[1]/li/a"));
		for (WebElement web : svcs1) {
			if (web.getText().trim().equals("Save")) {
				visbility(driver, web, 60);
				javascriptclick(web);
				break;
			}

		}
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement prcdaddtplost = driver
						.findElement(By.xpath("(//span[contains(@title,'Add this procedure')])[1]"));

				visbility(driver, prcdaddtplost, 60);
				javascriptclick(prcdaddtplost);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement prcdfavkpopcl = driver
						.findElement(By.xpath("//div[@id='ProcedureFavKpop2']/div[1]/div[2]/span"));
				visbility(driver, prcdfavkpopcl, 60);
				javascriptclick(prcdfavkpopcl);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	@Test(priority = 6, invocationCount = 3)
	private void Goals() throws InterruptedException {

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement goalsfavicon = driver
						.findElement(By.xpath("//div[contains(@title,'Show my favorite Goals list for ')]"));
				actions("move to element", goalsfavicon);
				visbility(driver, goalsfavicon, 60);
				javascriptclick(goalsfavicon);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement goaslfavaddicon = driver.findElement(
						By.xpath("//div[@id='GoalsFavKpop2']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]"));
				visbility(driver, goaslfavaddicon, 60);
				javascriptclick(goaslfavaddicon);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		WebElement pellcontenticon = driver.findElement(By.xpath("//div[@id='GoalsPellVal']/div[1]/button[1]"));
		visbility(driver, pellcontenticon, 60);
		javascriptclick(pellcontenticon);
		WebElement goasldis = driver.findElement(By.xpath("//div[@id='GoalsPellVal']/div[2]"));
		visbility(driver, goasldis, 60);
		sendkeys(goasldis, "GOALS MODULE FAVORITE");

		WebElement goaslfavsave = driver.findElement(By.xpath("//div[@id='addfav-div']/div[1]//following::button[2]"));
		visbility(driver, goaslfavsave, 60);
		javascriptclick(goaslfavsave);
		sleep(1500);
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement addgoasltolist = driver
						.findElement(By.xpath("(//span[contains(@title,'Add this goal')])[1]"));
				visbility(driver, addgoasltolist, 60);
				javascriptclick(addgoasltolist);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement closegoaslfavwin = driver
						.findElement(By.xpath("//div[@id='GoalsFavKpop2']/div[1]/div[2]/span"));
				visbility(driver, closegoaslfavwin, 60);
				javascriptclick(closegoaslfavwin);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	@Test(invocationCount = 2, priority = 8)
	private void status() throws InterruptedException {

		for (int i = 1; i <= 5; i++) {
			try {

				WebElement statusfavicon = driver
						.findElement(By.xpath("//div[contains(@title,'Show my favorite Status list for ')]"));
				actions("move to element", statusfavicon);
				visbility(driver, statusfavicon, 60);
				javascriptclick(statusfavicon);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		for (int in = 1; in <= 5; in++) {
			try {
				WebElement $statusEhrFavAdd$ = driver.findElement(
						By.xpath("//div[@id='StatusFavKpop2']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]"));
				visbility(driver, $statusEhrFavAdd$, 60);
				javascriptclick($statusEhrFavAdd$);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		for (int in = 1; in <= 5; in++) {
			try {
				WebElement statusdropdwn = driver
						.findElement(By.xpath("//div[@id='StatusKpop2']/div[2]/div[1]/select"));
				visbility(driver, statusdropdwn, 60);
				dropDown("index", statusdropdwn, "2");
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		WebElement statusdis = driver
				.findElement(By.xpath("//div[@id='StatusKpop2']/div[2]/div[1]/select//following::input[1]"));
		visbility(driver, statusdis, 60);
		List<WebElement> $statusicddrp$;
		sendkeys(statusdis, "test");
		while (true) {
			try {
				$statusicddrp$ = driver.findElements(By.xpath(
						"//div[@id='StatusKpop2']/div[2]/div[1]/select//following::input[1]//following::ul[1]/li/a/div"));
				if ($statusicddrp$.size() > 5) {
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		for (WebElement we : $statusicddrp$) {
			if (we.getText().trim().equals("134374006: Hearing test bilateral abnormality (finding)")) {
				visbility(driver, we, 60);
				javascriptclick(we);
				break;
			}

		}
		WebElement savestatus = driver.findElement(By.xpath("//div[@id='StatusKpop2']/div[2]/div[2]/button[2]"));
		visbility(driver, savestatus, 60);
		javascriptclick(savestatus);
		sleep(1500);
		for (int in = 1; in <= 5; in++) {
			try {
				WebElement editstatus = driver
						.findElement(By.xpath("(//div[contains(text(),'134374006: Hearing test bilateral')])[1]"));

				visbility(driver, editstatus, 60);
				javascriptclick(editstatus);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		WebElement crossiconstatus = driver
				.findElement(By.xpath("(//span[text()='134374006'])[1]//following::span[1]"));
		visbility(driver, crossiconstatus, 60);
		javascriptclick(crossiconstatus);

		WebElement statusdis2 = driver
				.findElement(By.xpath("//div[@id='StatusKpop2']/div[2]/div[1]/select//following::input[1]"));
		visbility(driver, statusdis2, 60);
		sendkeys(statusdis2, "test");
		List<WebElement> $stsdrp$;
		while (true) {
			try {
				$stsdrp$ = driver.findElements(By.xpath(
						"//div[@id='StatusKpop2']/div[2]/div[1]/select//following::input[1]//following::ul[1]/li/a/div"));
				if ($stsdrp$.size() > 5) {
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		for (WebElement we : $stsdrp$) {
			if (we.getText().trim().equals("134376008: Hearing test right abnormality (finding)")) {
				visbility(driver, we, 60);
				javascriptclick(we);
				break;
			}

		}
		WebElement savestatus2 = driver.findElement(By.xpath("//div[@id='StatusKpop2']/div[2]/div[2]/button[2]"));
		visbility(driver, savestatus2, 60);
		javascriptclick(savestatus2);
		for (int in = 1; in <= 5; in++) {
			try {
				WebElement addstatus = driver.findElement(By.xpath("(//span[contains(@title,'Add this status')])[1]"));
				visbility(driver, addstatus, 60);
				javascriptclick(addstatus);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		for (int in = 1; in <= 5; in++) {
			try {
				WebElement statusclose = driver.findElement(By.xpath("//div[@id='StatusFavKpop2']/div[1]/div[2]/span"));

				visbility(driver, statusclose, 60);
				javascriptclick(statusclose);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	@Test(priority = 3, invocationCount = 4)
	private void problem() {

		WebElement pr1 = driver.findElement(By.xpath("//div[contains(@title,'Show my favorite Problems list ')]"));
		actions("move to element", pr1);
		visbility(driver, pr1, 60);
		javascriptclick(pr1);

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement $prob_fav_kpop$ = driver.findElement(By.xpath(
						"//div[@id='ProblemsFavKpop2']//following::div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]"));
				visbility(driver, $prob_fav_kpop$, 60);
				javascriptclick($prob_fav_kpop$);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement $probSendkeys$ = driver
				.findElement(By.xpath("(//div[@id='ProblemsKpop2']//following::input[1])[1]"));
		visbility(driver, $probSendkeys$, 60);
		sendkeys($probSendkeys$, "test");
		List<WebElement> $probDrop$;
		while (true) {
			$probDrop$ = driver.findElements(
					By.xpath("//div[@id='ProblemsKpop2']/div[2]/div[2]//following::ul[1]/li/a/div/small"));
			if ($probDrop$.size() > 7)
				break;
		}
		// System.out.println($probDrop$.size());
		for (WebElement web : $probDrop$) {

			if (web.getText().trim().equals("ICD10 : C62 | SNOMED : --")) {
				web.click();
				break;
			}

		}
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement $problemsNotes$ = driver
						.findElement(By.xpath("(//div[@id='ProblemsKpop2']//following::input[2])[1]"));
				sendkeys($problemsNotes$, "problems");
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement $problemsave$ = driver
						.findElement(By.xpath("(//div[@id='ProblemsKpop2']//following::button[2])[1]"));
				click($problemsave$);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement $problemedit$ = driver.findElement(By.xpath("(//span[text()='Malignant neoplasm of testis'])[1]"));
		click($problemedit$);

		WebElement $cancel_icon_prblem$ = driver
				.findElement(By.xpath("//td[text()='Malignant neoplasm of testis']//following::div[1]"));
		visbility(driver, $cancel_icon_prblem$, 60);
		click($cancel_icon_prblem$);

		WebElement $probSendkeyss$ = driver
				.findElement(By.xpath("(//div[@id='ProblemsKpop2']//following::input[1])[1]"));
		visbility(driver, $probSendkeyss$, 60);
		sendkeys($probSendkeyss$, "test");
		List<WebElement> $probDropp$;
		while (true) {
			$probDropp$ = driver.findElements(
					By.xpath("//div[@id='ProblemsKpop2']/div[2]/div[2]//following::ul[1]/li/a/div/small"));
			if ($probDropp$.size() > 7)
				break;
		}
		// System.out.println($probDrop$.size());
		for (WebElement web : $probDropp$) {

			if (web.getText().trim().equals("ICD10 : C62 | SNOMED : --")) {
				web.click();
				break;
			}

		}

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement $problemsave$ = driver
						.findElement(By.xpath("(//div[@id='ProblemsKpop2']//following::button[2])[1]"));
				click($problemsave$);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement $add_problem_to_list$ = driver.findElement(By.xpath(
						"(//span[text()='Malignant neoplasm of testis'])[1]//parent::div//parent::div[1]//parent::div[1]/div[1]/span[1]"));
				click($add_problem_to_list$);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement $cancelprobKpop2$ = driver
				.findElement(By.xpath("(//div[@id='ProblemsFavKpop2']/div[1]//following::span[1])[1]"));
		click($cancelprobKpop2$);
	}

	@Test(invocationCount = 3, priority = 9)
	private void Medication() throws InterruptedException {

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement medfav = driver
						.findElement(By.xpath("(//div[contains(@title,'Show my favorite Medications list ')])[1]"));
				actions("move to element", medfav);
				visbility(driver, medfav, 60);
				javascriptclick(medfav);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		WebElement medaddbtn = driver.findElement(
				By.xpath("//div[@id='MedicationsFavKpop2']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]"));
		visbility(driver, medaddbtn, 60);
		javascriptclick(medaddbtn);
		WebElement meddisbox = driver
				.findElement(By.xpath("//div[@id='MedicationsKpop2']/div[2]/div[1]/div[1]/div[2]/input"));
		visbility(driver, meddisbox, 60);
		sendkeys(meddisbox, "test");
		List<WebElement> $med$drop$down$;

		while (true) {
			try {
				$med$drop$down$ = driver.findElements(
						By.xpath("//div[@id='MedicationsKpop2']/div[2]/div[3]//following::ul[1]/li/a/div/small/em"));
				if ($med$drop$down$.size() > 5) {
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		for (WebElement we : $med$drop$down$) {
			System.out.println(we.getText());
			if (we.getText().trim().equals("RXNORM : 1009480")) {
				// System.out.println("med cond met");
				visbility(driver, we, 60);
				javascriptclick(we);
				break;

			}

		}

		WebElement savemed = driver
				.findElement(By.xpath("//div[@id='addfav-div']/div/div/div[4]//following::button[3]"));
		visbility(driver, savemed, 60);
		javascriptclick(savemed);
		sleep(1500);
		// edit acenario...
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement $editmed$ = driver.findElement(By.xpath("(//span[text()='RXNORM : 1009480: '])[1]"));
				visbility(driver, $editmed$, 60);
				javascriptclick($editmed$);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement $crossicon$ = driver.findElement(By.xpath("//div[@title='Remove this Medication']"));
		visbility(driver, $crossicon$, 60);
		javascriptclick($crossicon$);

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement $meddisbox$ = driver
						.findElement(By.xpath("//div[@id='MedicationsKpop2']/div[2]/div[1]/div[1]/div[2]/input"));

				sendkeys($meddisbox$, "test");
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		List<WebElement> $med$drop$downs$;

		while (true) {
			try {
				$med$drop$downs$ = driver.findElements(
						By.xpath("//div[@id='MedicationsKpop2']/div[2]/div[3]//following::ul[1]/li/a/div/small/em"));
				if ($med$drop$downs$.size() > 5) {
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		for (WebElement we : $med$drop$downs$) {
			System.out.println(we.getText());
			if (we.getText().trim().equals("RXNORM : 1010630")) {

				visbility(driver, we, 60);
				javascriptclick(we);
				break;

			}

		}

		WebElement $savemeds$ = driver
				.findElement(By.xpath("//div[@id='addfav-div']/div/div/div[4]//following::button[3]"));
		visbility(driver, $savemeds$, 60);
		javascriptclick($savemeds$);

		for (int i = 1; i <= 5; i++) {
			try {

				WebElement addmedtolist = driver
						.findElement(By.xpath("(//span[contains(@title,'Add this medication to prescription')])[1]"));
				visbility(driver, addmedtolist, 60);
				javascriptclick(addmedtolist);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement cancel = driver
						.findElement(By.xpath("//div[@id='MedicationsFavKpop2']/div[1]/div[1]//following::span[1]"));
				visbility(driver, cancel, 60);
				javascriptclick(cancel);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	@Test(priority = 7, invocationCount = 4)
	private void AdvanceDirectives() {

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement addnewfavadv = driver
						.findElement(By.xpath("//div[contains(@title,'Show my favorite Advance directives list ')]"));
				actions("move to element", addnewfavadv);
				visbility(driver, addnewfavadv, 60);
				javascriptclick(addnewfavadv);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement $Advnce_Dir_Add$ = driver.findElement(By.xpath(
						"//div[@id='Advance_DirectivesFavKpop2']//following::div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]"));
				click($Advnce_Dir_Add$);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement $adv_dir_drop$ = driver
						.findElement(By.xpath("(//div[@id='Advance_DirectivesKpop2']//following::select[1])[1]"));
				dropDown("text", $adv_dir_drop$, "Assessment");
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement $adv_dis$ = driver.findElement(
				By.xpath("(//div[@id='Advance_DirectivesKpop2']//following::select[1])[1]//following::input[1]"));
		sendkeys($adv_dis$, "Advance directives");

		WebElement $save_adv$ = driver
				.findElement(By.xpath("//div[@id='Advance_DirectivesKpop2']/div[2]/div[2]/button[2]"));
		click($save_adv$);

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement $edit_adv$ = driver.findElement(By.xpath("(//span[text()='Assessment'])[1]"));
				click($edit_adv$);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement $adv_dis2$ = driver.findElement(
				By.xpath("(//div[@id='Advance_DirectivesKpop2']//following::select[1])[1]//following::input[1]"));
		clear($adv_dis2$);
		sendkeys($adv_dis2$, "Advance directives");

		WebElement $save_adv1$ = driver
				.findElement(By.xpath("//div[@id='Advance_DirectivesKpop2']/div[2]/div[2]/button[2]"));
		click($save_adv1$);
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement $add_dirToList$ = driver.findElement(By.xpath(
						"((//span[text()='Assessment'])[1]//parent::div//parent::div[1]//parent::div[1]/div[1]/span[1])[1]"));
				click($add_dirToList$);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement $closeIconAdvFavKpop$ = driver
				.findElement(By.xpath("//div[@id='Advance_DirectivesFavKpop2']/div[1]/div[2]/span"));
		click($closeIconAdvFavKpop$);
	}

	@Test(invocationCount = 3, priority = 10)
	private void Notes() throws InterruptedException {

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement notefav = driver
						.findElement(By.xpath("//div[contains(@title,'Show my favorite Notes list ')]"));
				actions("move to element", notefav);

				javascriptclick(notefav);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement addnotetn = driver
				.findElement(By.xpath("//div[@id='NotesFavKpop2']/div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]"));

		visbility(driver, addnotetn, 60);
		javascriptclick(addnotetn);
		WebElement notesdis = driver.findElement(By.xpath("//div[@id='NotesPellVal']/div[2]"));
		visbility(driver, notesdis, 60);
		sendkeys(notesdis, "Notes module");
		WebElement savenotesfav = driver
				.findElement(By.xpath("//div[@id='NotesPellVal']/div[2]//following::button[2]"));
		visbility(driver, savenotesfav, 60);
		javascriptclick(savenotesfav);
		sleep(1500);

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement editnt = driver.findElement(By.xpath("(//div[text()='Notes module'])[1]"));
				visbility(driver, editnt, 60);
				javascriptclick(editnt);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement notesdis2 = driver.findElement(By.xpath("//div[@id='NotesPellVal']/div[2]"));
				clear(notesdis2);
				sendkeys(notesdis2, "Notes");
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		WebElement savenotesfav2 = driver
				.findElement(By.xpath("//div[@id='NotesPellVal']/div[2]//following::button[2]"));
		visbility(driver, savenotesfav2, 60);
		javascriptclick(savenotesfav2);
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement addtolist = driver.findElement(By.xpath("(//span[contains(@title,'Add this note')])[2]"));
				visbility(driver, addtolist, 60);
				javascriptclick(addtolist);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement cancelnote = driver.findElement(By.xpath("//div[@id='NotesFavKpop2']/div[1]/div[2]/span"));
				visbility(driver, cancelnote, 60);
				javascriptclick(cancelnote);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	@Test(priority = 11, invocationCount = 4)

	private void PhysicalExamination() throws InterruptedException {

		for (int i = 1; i <= 5; i++) {
			try {

				WebElement pysaddfav = driver
						.findElement(By.xpath("//div[contains(@title,'Show my favorite Physical Examination list')]"));
				actions("move to element", pysaddfav);
				visbility(driver, pysaddfav, 60);

				javascriptclick(pysaddfav);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		for (int in = 1; in <= 5; in++) {
			try {
				WebElement $addPhysExam$ = driver.findElement(By.xpath(
						"//div[@id='Physical_ExaminationsFavKpop2']//following::div[2]/div[1]/div/table/tbody/tr/td[4]/span[2]"));

				javascriptclick($addPhysExam$);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement x2 = driver.findElement(By.id("bodyParts"));
		visbility(driver, x2, 60);
		sendkeys(x2, "hello");// .sendKeys("hello");

		WebElement x3 = driver.findElement(By.id("finding"));
		visbility(driver, x3, 60);
		sendkeys(x3, "hw are you");// .sendKeys("hw are you");

		WebElement x4 = driver.findElement(By.xpath("//div[@id='pNotes']/div[2]/input"));
		visbility(driver, x4, 60);
		sendkeys(x4, "Physical Examination modules");// .sendKeys("Physical Examination modules");
		WebElement abc = driver
				.findElement(By.xpath("//div[@id='Physical_ExaminationsKpop2']/div[2]/div[2]/button[2]"));
		visbility(driver, abc, 60);
		ww.until(ExpectedConditions.elementToBeClickable(abc));
		javascriptclick(abc);

		for (int in = 1; in <= 5; in++) {
			try {
				WebElement $editPhysc$ = driver.findElement(By.xpath("(//div[text()='hello'])[1]"));
				javascriptclick($editPhysc$);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement pysc1 = driver.findElement(By.id("bodyParts"));
		visbility(driver, pysc1, 60);
		clear(pysc1);
		sendkeys(pysc1, "hello");// .sendKeys("hello");

		WebElement pysc2 = driver.findElement(By.id("finding"));
		visbility(driver, pysc2, 60);
		clear(pysc2);
		sendkeys(pysc2, "hw are you");// .sendKeys("hw are you");

		WebElement $savePysc$ = driver
				.findElement(By.xpath("//div[@id='Physical_ExaminationsKpop2']/div[2]/div[2]/button[2]"));
		visbility(driver, $savePysc$, 60);
		ww.until(ExpectedConditions.elementToBeClickable($savePysc$));
		javascriptclick($savePysc$);

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement $addPyscTolist$ = driver.findElement(
						By.xpath("(//div[text()='hello'])[1]//parent::div[1]//parent::div[1]/div[1]/span[1]"));
				click($addPyscTolist$);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		for (int i = 1; i <= 5; i++) {
			try {

				WebElement $closePyscKpop2$ = driver
						.findElement(By.xpath("//span[text()='Favorite Physical Examinations']//following::span[1]"));
				click($closePyscKpop2$);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

}
