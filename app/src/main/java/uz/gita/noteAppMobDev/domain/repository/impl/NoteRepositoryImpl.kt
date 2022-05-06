package uz.gita.noteAppMobDev.domain.repository.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.noteAppMobDev.data.sourse.local.dao.NoteDao
import uz.gita.noteAppMobDev.data.sourse.local.entity.NoteEntity
import uz.gita.noteAppMobDev.domain.repository.NoteRepository
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(private val noteDao: NoteDao) : NoteRepository {

    override suspend fun createNote(noteEntity: NoteEntity) {
        noteDao.insert(noteEntity)
    }

    override fun getNotes(): Flow<List<NoteEntity>> = noteDao.getNotes()
}