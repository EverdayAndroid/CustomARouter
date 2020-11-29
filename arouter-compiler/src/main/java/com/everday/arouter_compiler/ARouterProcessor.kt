package com.everday.arouter_compiler

import com.google.auto.service.AutoService
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
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
@SupportedSourceVersion(SourceVersion.RELEASE_7) //环境版本

//接收android工程传过来的参数
@SupportedOptions("everDay")
class ARouterProcessor:AbstractProcessor() {
    //操作Element的工具类（类，函数，属性；都是Element）
    var element:Elements? = null
    //type(类信息)的工具类，包含用于操作TYpeMirror的工具方法
    var typeTool:Types? = null
    //日志打印信息
    var mess:Messager? = null
    //文件生成器，类、资源就是最终要生成的文件  是需要Filer来完成的
    var filer:Filer? = null

    override fun init(processingEnvironment: ProcessingEnvironment?) {
        super.init(processingEnvironment)
        element = processingEnvironment?.elementUtils
        mess = processingEnvironment?.messager
        filer = processingEnvironment?.filer
        val androidParams = processingEnvironment?.options?.get("everDay")

        //注解处理器里面抛出异常使用Diagnostic.Kind.ERROR
        mess?.printMessage(Diagnostic.Kind.NOTE,"android工程参数========>$androidParams")

    }

    //编译干活
    override fun process(annotations: MutableSet<out TypeElement>?, round: RoundEnvironment?): Boolean {
        mess?.printMessage(Diagnostic.Kind.NOTE,"process=========>开始编译")
        return true
    }
}