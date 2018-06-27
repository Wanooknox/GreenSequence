package com.company.BasicDOD;

import com.company.DemoCommon.Vector2;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ParallelParticleMovementSystem {

    private static ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

    public ParallelParticleMovementSystem() {
        executor.allowCoreThreadTimeOut(false);
        executor.prestartAllCoreThreads();
    }

    public void update(List<ParticleData> particles, int batchSize) {
        int batchCount = particles.size() / batchSize;

        for (int i = 0; i < batchCount; i++) {
            int startIndex = i * batchSize;
            executor.execute(() -> executeBatch(particles, startIndex, batchSize));
        }
        while (executor.getTaskCount() != executor.getCompletedTaskCount()) {
            // wait
        }
    }

    private void executeBatch(List<ParticleData> particles, int startIndex, int batch) {
        int endIndex = Math.max(startIndex + batch, particles.size());

        for (int i = startIndex; i < endIndex; i++) {
            update(particles.get(i).position, particles.get(i).velocity);
        }
    }

    private void update(Vector2 position, Vector2 velocity) {
         position.addMutate(velocity);
    }

}
