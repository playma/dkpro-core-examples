/*******************************************************************************
 * Copyright 2016
 * Ubiquitous Knowledge Processing (UKP) Lab
 * Technische Universität Darmstadt
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package de.tudarmstadt.ukp.dkpro.core.examples.embeddings;

import org.junit.Test;

import java.nio.file.Files;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LemmaEmbeddingsPipelineTest
{
    @Test
    public void testMain()
            throws Exception
    {
        int expectedSize = 27;
        int dimensionality = 50;
        LemmaEmbeddingsPipeline.TARGET_FILE.delete();

        LemmaEmbeddingsPipeline.main(new String[] {});
        List<String> output = Files.readAllLines(LemmaEmbeddingsPipeline.TARGET_FILE.toPath());

        assertEquals(expectedSize, output.size());
        assertTrue(output.stream().allMatch(line -> line.split(" ").length == dimensionality + 1));
    }
}