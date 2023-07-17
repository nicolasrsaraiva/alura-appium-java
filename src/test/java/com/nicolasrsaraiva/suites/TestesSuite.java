package com.nicolasrsaraiva.suites;

import com.nicolasrsaraiva.tests.CadastroTest;
import com.nicolasrsaraiva.tests.LoginTest;
import com.nicolasrsaraiva.tests.ProdutosTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CadastroTest.class,
        LoginTest.class,
        ProdutosTest.class,
})
public class TestesSuite {
}
