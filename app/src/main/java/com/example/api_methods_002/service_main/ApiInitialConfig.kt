package com.example.api_methods_002.service_main

enum class EnviromentConfig(val env: String) {

    DEV("dev"), HML("hml"), SANDBOX("sandbox"), PRODUCTION("production")
}

class Enviroment() {

    var urlBase: String = ""
    var apiKey: String = ""
}

class ApiInitialConfig {

    private var RUN_ENV: String = "sandbox"

    fun getEnviroment(): Enviroment {

        val enviroment = Enviroment()

        when (RUN_ENV) {

            EnviromentConfig.DEV.env -> {

                enviroment.apiKey = ""
                enviroment.urlBase = "https://jsonplaceholder.typicode.com/"
            }

            EnviromentConfig.HML.env -> {

                enviroment.apiKey = ""
                enviroment.urlBase = "https://jsonplaceholder.typicode.com/"
            }

            EnviromentConfig.SANDBOX.env -> {

                enviroment.apiKey = ""
                enviroment.urlBase = "https://jsonplaceholder.typicode.com/"
            }

            else -> {

                enviroment.apiKey = ""
                enviroment.urlBase = ""
            }
        }
        return enviroment
    }
}