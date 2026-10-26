
package uce.desarrolloweb.electrostock.Service;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.List;

import uce.desarrolloweb.electrostock.Model.Product;
import uce.desarrolloweb.electrostock.Repository.ProductRepository;

class ProductServiceTest {

    @Test
    void shouldReturnProductWhenIdExists() {
        // Arrange: Prepare a fake repository and a sample product.
        ProductRepository repository = mock(ProductRepository.class);
        Product product = new Product();

        when(repository.findById(1L))
                .thenReturn(Optional.of(product));

        ProductService service = new ProductService(repository);

        // Act: Execute the method we want to test.
        Product result = service.findById(1L);

        // Assert: Verify the returned product and repository call.
        assertSame(product, result);
        verify(repository).findById(1L);
    }
    @Test
    void shouldReturnNullWhenProductDoesNotExist() {
        // Arrange: Simulate a repository without the requested product.
        ProductRepository repository = mock(ProductRepository.class);

        when(repository.findById(99L))
                .thenReturn(Optional.empty());

        ProductService service = new ProductService(repository);

        // Act: Search for a product that does not exist.
        Product result = service.findById(99L);

        // Assert: Confirm that the service returns null.
        assertNull(result);
        verify(repository).findById(99L);
    }
    @Test
    void shouldReturnAllProducts() {
        // Arrange
        ProductRepository repository = mock(ProductRepository.class);

        Product firstProduct = new Product();
        Product secondProduct = new Product();

        List<Product> products = List.of(firstProduct, secondProduct);

        when(repository.findAll()).thenReturn(products);

        ProductService service = new ProductService(repository);

        // Act
        List<Product> result = service.findAll();

        // Assert
        assertEquals(2, result.size());
        assertEquals(products, result);
        verify(repository).findAll();
    }
}
