package com.example.api_methods_002.method_post.model

import android.content.Context
import com.example.api_methods_002.service_main.ApiConnection
import com.google.gson.annotations.SerializedName
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Response
import java.io.IOException

data class SigninPostModelBody(

    val identificationNumber: Int,
    val cpf: Int,
    val name: String,
    val email: String,
    val city: String
)

class SigninConsts private constructor() {

    object KEY {

        var USER_DOC = "user_document"
    }
}

class SigninPostModelResponse {

    @SerializedName("token")
    var token: String? = null
}

class SigninPostModelError {

    @SerializedName("status")
    var status: Int? = null

    @SerializedName("message")
    var message: String? = null

    @SerializedName("code")
    var code: String? = null
}

class SigninResponseErrorConvert(context: Context) {

    val service = ApiConnection(context)

    fun parseError(response: Response<*>): SigninPostModelError {

        val converter: Converter<ResponseBody, SigninPostModelError> = service.getRetrofitInstance()
            .responseBodyConverter(SigninPostModelError::class.java, arrayOfNulls<Annotation>(0))
        val error: SigninPostModelError

        error = try {
            converter.convert(response.errorBody())!!
        } catch (e: IOException) {

            return SigninPostModelError()
        }

        return error
    }
}

class SigninErrorsKeys constructor() {

    companion object {

        val errorsMap = mapOf(
            "wrong_password_or_username" to "Usuário ou senha errada",
            "generic_error" to "Não foi possível realizar a solicitação, tente novamente!"
        )
    }
}



