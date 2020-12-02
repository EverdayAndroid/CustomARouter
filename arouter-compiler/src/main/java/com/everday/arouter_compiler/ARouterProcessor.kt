package com.everday.arouter_compiler

import com.everday.arouter_annotation.Route
import com.google.auto.service.AutoService
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.TypeSpec
import java.io.IOException
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.Modifier
import javax.lang.model.element.TypeElement
import javax.lang.model.util.Elements
import javax.lang.model.util.Types
import javax.tools.Diagnostic
import javax.tools.DiagnosticListener

/**
 * @author wt
 * @date 22:31 2020/11/29
 * @description  编译会执行process方法
 **/
@AutoService(Processor::class) //启动服务
@SupportedAnnotationTypes("com.everday.arouter_annotation.Route") //注解信息
@SupportedSourceVersion(SourceVersion.RELEASE_8) //环境版本
//接收android工程传过来的参数
@SupportedOptions("moduleName")
class ARouterProcessor : AbstractProcessor() {
    //操作Element的工具类（类，函数，属性；都是Element）
    var element: Elements? = null

    //type(类信息)的工具类，包含用于操作TYpeMirror的工具方法
    var typeTool: Types? = null

    //日志打印信息
    var mess: Messager? = null

    //文件生成器，类、资源就是最终要生成的文件  是需要Filer来完成的
    var filer: Filer? = null

    override fun init(processingEnvironment: ProcessingEnvironment?) {
        super.init(processingEnvironment)
        element = processingEnvironment?.elementUtils
        mess = processingEnvironment?.messager
        filer = processingEnvironment?.filer
        val androidParams = processingEnvironment?.options?.get("moduleName")

        //注解处理器里面抛出异常使用Diagnostic.Kind.ERROR
        mess?.printMessage(Diagnostic.Kind.WARNING, "$androidParams  ==>")

    }

    //编译干活
    override fun process(
        annotations: MutableSet<out TypeElement>?,
        round: RoundEnvironment?
    ): Boolean {
        if (annotations.isNullOrEmpty()) {
//            mess?.printMessage(Diagnostic.Kind.NOTE, "process=========> run")?
        }
        val elements = round?.getElementsAnnotatedWith(Route::class.java)
        elements?.forEach {
            //方法
            val methodSpec = MethodSpec.methodBuilder("main")
                .addModifiers(Modifier.PUBLIC,Modifier.STATIC)
                .returns(Unit::class.java)
                .addParameter(Array<String>::class.java,"args")
                .build()

            //2.类
            val testClass = TypeSpec.classBuilder("EverDay1")
                .addMethod(methodSpec)
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .build()
            //3.包
            val javaFile = JavaFile.builder("com.everday1.apt", testClass).build()
            try {
                javaFile.writeTo(filer)
            }catch (e:IOException){
                e.printStackTrace()
            }
        }


//        mess?.printMessage(Diagnostic.Kind.NOTE, "process=========>")
        return false
    }
}