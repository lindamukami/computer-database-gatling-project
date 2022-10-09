package com.gatling.tests

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class ComputerDatabase extends Simulation {

	val httpProtocol = http
		.baseUrl("https://computer-database.gatling.io")
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-US,en;q=0.9")
		.upgradeInsecureRequestsHeader("1")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/106.0.0.0 Safari/537.36")


	val scn = scenario("ComputerDatabase")
		.exec(http("ComputerDatabasePage")
			.get("/computers")
			)
		.pause(2)
		.exec(http("NewComputerPage")
			.get("/computers/new")
			)
		.pause(13)
		.exec(http("AddComputerPage")
			.post("/computers")

			.formParam("name", "MachinetypeA")
			.formParam("introduced", "")
			.formParam("discontinued", "")
			.formParam("company", "2"))
		.pause(10)
		.exec(http("FilterComputerPage")
			.get("/computers?f=machineTypeA")
			)


	setUp(scn.inject(atOnceUsers(3))).protocols(httpProtocol)
}