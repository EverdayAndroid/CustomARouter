//package com.everday.arouter_compiler;
//
//import com.everday.arouter_annotation.Route;
//import com.google.auto.service.AutoService;
//import com.squareup.javapoet.JavaFile;
//import com.squareup.javapoet.MethodSpec;
//import com.squareup.javapoet.TypeSpec;
//
//import java.io.IOException;
//import java.util.Iterator;
//import java.util.Set;
//
//import javax.annotation.processing.AbstractProcessor;
//import javax.annotation.processing.Filer;
//import javax.annotation.processing.Messager;
//import javax.annotation.processing.ProcessingEnvironment;
//import javax.annotation.processing.Processor;
//import javax.annotation.processing.RoundEnvironment;
//import javax.annotation.processing.SupportedAnnotationTypes;
//import javax.annotation.processing.SupportedOptions;
//import javax.annotation.processing.SupportedSourceVersion;
//import javax.lang.model.SourceVersion;
//import javax.lang.model.element.Element;
//import javax.lang.model.element.Modifier;
//import javax.lang.model.element.TypeElement;
//import javax.lang.model.util.Elements;
//import javax.lang.model.util.Types;
//import javax.tools.Diagnostic;
//
///**
// * @author wt
// * @date 22:31 2020/11/29
// * @description  编译会执行process方法
// **/
//@AutoService(Processor.class) //启动服务
//@SupportedAnnotationTypes("com.everday.arouter_annotation.Route") //注解信息
//@SupportedSourceVersion(SourceVersion.RELEASE_8) //环境版本
////接收android工程传过来的参数
//@SupportedOptions("moduleName")
//public class ARouterProcessorJava extends AbstractProcessor {
//    //操作Element的工具类（类，函数，属性；都是Element）
//    private Elements element;
//
//    //type(类信息)的工具类，包含用于操作TYpeMirror的工具方法
//    private Types typeTool;
//
//    //日志打印信息
//    private Messager mess;
//
//    //文件生成器，类、资源就是最终要生成的文件  是需要Filer来完成的
//    private Filer filer;
//
//    @Override
//    public synchronized void init(ProcessingEnvironment processingEnvironment) {
//        super.init(processingEnvironment);
//        element = processingEnvironment.getElementUtils();
//        mess = processingEnvironment.getMessager();
//        filer = processingEnvironment.getFiler();
//        String moduleName = processingEnvironment.getOptions().get("moduleName");
//        mess.printMessage(Diagnostic.Kind.NOTE,moduleName+"====100");
//    }
//
//    @Override
//    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
//        mess.printMessage(Diagnostic.Kind.NOTE,"====10013");
//        Set<? extends Element> elementsAnnotatedWith = roundEnvironment.getElementsAnnotatedWith(Route.class);
//        Iterator<? extends Element> iterator = elementsAnnotatedWith.iterator();
//        while (iterator.hasNext()){
//            Element element = iterator.next();
//            MethodSpec methodSpec = MethodSpec.methodBuilder("main")
//                    .addModifiers(Modifier.PUBLIC)
//                    .addParameter(String[].class,"args")
//                    .addStatement("$T.out.println($S)","System","hi wt")
//                    .build();
//
//            TypeSpec android = TypeSpec.classBuilder("Android")
//                    .addMethod(methodSpec)
//                    .build();
//            JavaFile javaFile = JavaFile.builder("com.apt.demo", android).build();
//            try {
//                javaFile.writeTo(filer);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return false;
//    }
//}
