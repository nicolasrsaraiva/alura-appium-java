package com.nicolasrsaraiva.suites;

import com.nicolasrsaraiva.tests.CadastroTest;
import com.nicolasrsaraiva.tests.LoginTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CadastroTest.class,
        LoginTest.class
})
public class AutenticacaoSuite {
}
